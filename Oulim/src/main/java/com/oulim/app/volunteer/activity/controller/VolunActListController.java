package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("====VolunActListController 실행====");

		// DAO 생성
		VolunteerActivityDAO volunteerDAO = new VolunteerActivityDAO();

		// DTO 생성 + 파라미터 세팅
		VolunActivityDTO dto = new VolunActivityDTO();
		dto.setActType(request.getParameter("actType"));
		dto.setRecruitStatus(request.getParameter("recruitStatus"));
		dto.setKeyword(request.getParameter("keyword"));
		VolunActivityDTO dto = new VolunActivityDTO();

		// actType
		String actType = request.getParameter("actType");
		if(actType != null && !actType.equals("")) {
		    dto.setActType(Integer.parseInt(actType));
		}

		// ageGroup
		String ageGroup = request.getParameter("ageGroup");
		if(ageGroup != null && !ageGroup.equals("")) {
		    dto.setAgeGroup(Integer.parseInt(ageGroup));
		}

		// recruitStatus
		String recruitStatus = request.getParameter("recruitStatus");
		if(recruitStatus != null && !recruitStatus.equals("")) {
		    dto.setRecruitStatus(Integer.parseInt(recruitStatus));
		}

		// keyword
		String keyword = request.getParameter("keyword");
		if(keyword != null && !keyword.trim().equals("")) {
		    dto.setKeyword(keyword);
		}

		// searchType
		String searchType = request.getParameter("searchType");
		if(searchType != null && !searchType.equals("")) {
		    dto.setSearchType(searchType);
		}

		// DB 조회
		List<VolunActivityDTO> list = volunteerDAO.selectVolActList(dto);

		// request 저장
		request.setAttribute("volunteerList", list);

		// 이동
		Result result = new Result();
		result.setPath("/app/volunteer-activity/volunAct-list.jsp");
		result.setRedirect(false);

		return result;
	}
}