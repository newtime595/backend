package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.user.dao.UserDAO;
import com.oulim.app.user.dto.UserDTO;

public class IdFindController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		HttpSession session = request.getSession();

		String userName = request.getParameter("userName");
		String userBirth = request.getParameter("userBirth");
		String userEmail = request.getParameter("userEmail");
		String inputCode = request.getParameter("verify");

		String sessionCode = (String) session.getAttribute("emailAuthCode");
		String sessionEmail = (String) session.getAttribute("emailAuthEmail");
		Long emailAuthTime = (Long) session.getAttribute("emailAuthTime");

		if (userName == null || userName.trim().isEmpty()) {
			request.setAttribute("error", "이름을 입력해주세요.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		if (userBirth == null || userBirth.trim().isEmpty()) {
			request.setAttribute("error", "생년월일을 입력해주세요.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		if (userEmail == null || userEmail.trim().isEmpty()) {
			request.setAttribute("error", "이메일을 입력해주세요.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		if (inputCode == null || inputCode.trim().isEmpty()) {
			request.setAttribute("error", "인증번호를 입력해주세요.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		if (sessionCode == null || sessionEmail == null || emailAuthTime == null) {
			request.setAttribute("error", "인증번호가 만료되었거나 발송되지 않았습니다.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		if (!sessionEmail.equals(userEmail)) {
			request.setAttribute("error", "인증 요청한 이메일과 현재 입력한 이메일이 다릅니다.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		long now = System.currentTimeMillis();
		
		if (now - emailAuthTime > 1000 * 60 * 3) {
			session.removeAttribute("emailAuthCode");
			session.removeAttribute("emailAuthEmail");
			session.removeAttribute("emailAuthTime");

			request.setAttribute("error", "인증번호가 만료되었습니다.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		if (!sessionCode.equals(inputCode)) {
			request.setAttribute("error", "인증번호가 일치하지 않습니다.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
			result.setRedirect(false);
			return result;
		}

		userDTO.setUserName(userName);
		userDTO.setUserBirth(userBirth);
		userDTO.setUserEmail(userEmail);

		String userId = userDAO.findId(userDTO);

		if (userId != null) {
			request.setAttribute("userId", userId);
			result.setPath("/app/user/find-idpassword/id-find-view.jsp");
		} else {
			request.setAttribute("error", "일치하는 회원정보가 없습니다.");
			result.setPath("/app/user/find-idpassword/id-find.jsp");
		}

		session.removeAttribute("emailAuthCode");
		session.removeAttribute("emailAuthEmail");
		session.removeAttribute("emailAuthTime");

		result.setRedirect(false);
		return result;
	}
}