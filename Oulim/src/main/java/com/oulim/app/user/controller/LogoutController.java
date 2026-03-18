package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class LogoutController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if(session != null) {
			session.invalidate(); // 세션 전체 삭제
		}

		String referer = request.getHeader("Referer");

		Result result = new Result();
		result.setRedirect(true);
		result.setPath(referer != null ? referer : "/"); // 이전 페이지로 이동

		return result;
	}
}