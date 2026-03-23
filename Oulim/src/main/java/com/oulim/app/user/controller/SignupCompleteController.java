package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class SignupCompleteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		String joinType = request.getParameter("joinType"); // normal / organ

		if ("organ".equals(joinType)) {
			result.setPath("/app/user/signin/signup-complete-company.jsp");
		} else {
			result.setPath("/app/user/signin/signup-complete.jsp");
		}

		result.setRedirect(false);
		return result;
	}
}