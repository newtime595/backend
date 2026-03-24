package com.oulim.app.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class VerifyEmailAuthCodeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String userEmail = request.getParameter("userEmail");
		String authCode = request.getParameter("authCode");

		HttpSession session = request.getSession();

		String sessionCode = (String) session.getAttribute("emailAuthCode");
		String sessionEmail = (String) session.getAttribute("emailAuthEmail");
		Long authTime = (Long) session.getAttribute("emailAuthTime");

		if (sessionCode == null || sessionEmail == null || authTime == null) {
			out.print("fail");
			return null;
		}

		long now = System.currentTimeMillis();
		long limit = 3 * 60 * 1000;

		if (now - authTime > limit) {
			session.removeAttribute("emailAuthCode");
		    session.removeAttribute("emailAuthEmail");
		    session.removeAttribute("emailAuthTime");
		    
			out.print("expired");
			return null;
		}

		if (sessionEmail.equals(userEmail) && sessionCode.equals(authCode)) {
			session.setAttribute("emailVerified", true);
			
			session.removeAttribute("emailAuthCode");
		    session.removeAttribute("emailAuthEmail");
		    session.removeAttribute("emailAuthTime");
			out.print("success");
		} else {
			out.print("fail");
		}

		return null;
	}
}