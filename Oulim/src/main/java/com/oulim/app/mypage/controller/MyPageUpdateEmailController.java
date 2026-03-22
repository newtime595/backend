package com.oulim.app.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageUpdateEmailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		MyPageJoinDTO myPageJoinDTO = new MyPageJoinDTO();
		HttpSession session = request.getSession();

		Integer userNo = (Integer) session.getAttribute("userNo");
		String userEmail = request.getParameter("userEmail");
		String inputCode = request.getParameter("verify");

		String sessionCode = (String) session.getAttribute("emailAuthCode");
		String sessionEmail = (String) session.getAttribute("emailAuthEmail");
		Long emailAuthTime = (Long) session.getAttribute("emailAuthTime");

		if (userNo == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}

		if (userEmail == null || userEmail.trim().isEmpty()) {
			throw new ServletException("이메일을 입력해주세요.");
		}

		if (inputCode == null || inputCode.trim().isEmpty()) {
			throw new ServletException("인증번호를 입력해주세요.");
		}

		if (sessionCode == null || sessionEmail == null || emailAuthTime == null) {
			throw new ServletException("인증번호가 만료되었거나 발송되지 않았습니다.");
		}

		if (!sessionEmail.equals(userEmail)) {
			throw new ServletException("인증 요청한 이메일과 현재 입력한 이메일이 다릅니다.");
		}

		if (!sessionCode.equals(inputCode)) {
			throw new ServletException("인증번호가 일치하지 않습니다.");
		}

		long now = System.currentTimeMillis();
		if (now - emailAuthTime > 1000 * 60 * 3) { 
			session.removeAttribute("emailAuthCode");
			session.removeAttribute("emailAuthEmail");
			session.removeAttribute("emailAuthTime");
			throw new ServletException("인증번호가 만료되었습니다.");
		}

		myPageJoinDTO.setUserNo(userNo);
		myPageJoinDTO.setUserEmail(userEmail);

		mypageDAO.updateEmail(myPageJoinDTO);

		session.removeAttribute("emailAuthCode");
		session.removeAttribute("emailAuthEmail");
		session.removeAttribute("emailAuthTime");

		result.setPath(request.getContextPath() + "/mypage/organEdit.mp");
		result.setRedirect(true);

		return result;
	}
}