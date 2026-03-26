package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class VolunActApplyController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession();

		Integer userNo = (Integer) session.getAttribute("userNo");
		String volunActNoStr = request.getParameter("volunActNo");

		System.out.println("=== 신청 컨트롤러 진입 ===");
		System.out.println("session userNo : " + userNo);
		System.out.println("volunActNoStr : " + volunActNoStr);

		if (userNo == null) {
			result.setRedirect(true);
			result.setPath("/user/login.usr");
			return result;
		}

		if (volunActNoStr == null || volunActNoStr.trim().isEmpty()) {
			result.setRedirect(true);
			result.setPath("/volunteer-activity/list.va");
			return result;
		}

		int volunActNo = Integer.parseInt(volunActNoStr);
		VolunteerActivityDAO dao = new VolunteerActivityDAO();
		VolunActivityDTO volunActDTO = dao.selectDetail(volunActNo);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate recruBeginTime = LocalDate.parse(volunActDTO.getVolunActRecruBegin(),formatter);
		LocalDate recruEndTime = LocalDate.parse(volunActDTO.getVolunActRecruEnd(),formatter).minusDays(1);
		
		 System.out.println("봉사 모집 시작시간 : " + recruBeginTime);
		 System.out.println("신청 여부" + LocalDate.now().isBefore(recruBeginTime));
		 System.out.println("봉사 모집 종료시간 : " + recruEndTime);
		 System.out.println("신청 여부" + LocalDate.now().isAfter(recruEndTime));
		
		if( LocalDate.now().isBefore(recruBeginTime) ||
			LocalDate.now().isAfter(recruEndTime)) { 
			result.setRedirect(true);
		  result.setPath("/volunteer-activity/list.va");
		  return result;
		  }
	
		

		VolunApplyDTO dto = new VolunApplyDTO();
		dto.setVolunActNo(volunActNo);
		dto.setUserNo(userNo);

		System.out.println("dto : " + dto);

		dao.applyVolunteer(dto);

		System.out.println("=== 신청 완료 ===");

		result.setRedirect(true);
		result.setPath("/volunteer-activity/detail.va?volunActNo=" + volunActNo + "&message=applySuccess");
		return result;
	}

}
