package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class VolunActCancelController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession();

		Integer userNo = (Integer) session.getAttribute("userNo");
		String volunActNoStr = request.getParameter("volunActNo");

		System.out.println("=== 철회 컨트롤러 진입 ===");
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

		VolunApplyDTO dto = new VolunApplyDTO();
		dto.setVolunActNo(volunActNo);
		dto.setUserNo(userNo);

		System.out.println("cancel dto : " + dto);

		VolunteerActivityDAO dao = new VolunteerActivityDAO();
		dao.cancelVolunteer(dto);

		System.out.println("=== 철회 완료 ===");

		result.setRedirect(true);
		result.setPath("/volunteer-activity/detail.va?volunActNo=" + volunActNo + "&message=cancelSuccess");
		return result;
	}

}
