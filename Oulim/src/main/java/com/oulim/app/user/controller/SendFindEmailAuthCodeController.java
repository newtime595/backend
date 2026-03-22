package com.oulim.app.user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.MailUtil;
import com.oulim.app.user.dao.UserDAO;

public class SendFindEmailAuthCodeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		String userEmail = request.getParameter("userEmail");
		UserDAO userDAO = new UserDAO();
		System.out.println("아이디 찾기 받은 이메일: " + userEmail);

		if (userEmail == null || userEmail.trim().isEmpty()) {
			System.out.println("이메일 없음");
			out.print("empty");
			return null;
		}

		int count = userDAO.checkEmail(userEmail);

		if (count == 0) {
			out.print("notFound");
			return null;
		}

		String authCode = createAuthCode();
		System.out.println("생성된 인증코드: " + authCode);

		HttpSession session = request.getSession();
		session.setAttribute("emailAuthCode", authCode);
		session.setAttribute("emailAuthEmail", userEmail);
		session.setAttribute("emailAuthTime", System.currentTimeMillis());

		try {
			System.out.println("메일 발송 시작");
			MailUtil.sendMail(userEmail, authCode);
			System.out.println("메일 발송 성공");
			out.print("success");
		} catch (Exception e) {
			System.out.println("메일 발송 실패");
			e.printStackTrace();
			out.print("fail");
		}

		return null;
	}

	private String createAuthCode() {
		Random random = new Random();
		int code = 100000 + random.nextInt(900000);
		return String.valueOf(code);
	}
}