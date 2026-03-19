package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class NormalJoinFirstOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		Boolean emailVerified = (Boolean) request.getSession().getAttribute("emailVerified");

		if (emailVerified == null || !emailVerified) {
			throw new ServletException("이메일 인증이 완료되지 않았습니다.");
		}
		
		request.setAttribute("userName", request.getParameter("userName"));
		request.setAttribute("userBirth", request.getParameter("userBirth"));
		request.setAttribute("userEmail", request.getParameter("userEmail"));
		request.setAttribute("userPhoneNum", request.getParameter("userPhoneNum"));

		result.setPath("/app/user/signin/signup-info.jsp");
		result.setRedirect(false);

		return result;
	}

}
