package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class OrganJoinFirstOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		request.setAttribute("organName", request.getParameter("organName"));
		request.setAttribute("userName", request.getParameter("userName"));
		request.setAttribute("userBirth", request.getParameter("userBirth"));
		request.setAttribute("organCertNum", request.getParameter("organCertNum"));
		request.setAttribute("userEmail", request.getParameter("userEmail"));

		result.setPath("/app/user/signin/signup-info-company.jsp");
		result.setRedirect(false);

		return result;
	}

}
