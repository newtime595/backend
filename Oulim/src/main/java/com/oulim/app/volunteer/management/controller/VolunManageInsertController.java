package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class VolunManageInsertController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("봉사 등록 페이지 컨트롤러 이동 완료");
		Result result = new Result();
		HttpSession session = request.getSession();

//		Integer organNo = (Integer) session.getAttribute("organNo");
		Integer organNo=1;	//테스트
		String path = null;

		if (organNo == null) {
			path = "/app/member/login.jsp";
		} else {
			path = "/app/volunteer-management/volunteer-manage-register.jsp";
		}

		result.setPath(path);
		result.setRedirect(false);

		return result;
	}

}
