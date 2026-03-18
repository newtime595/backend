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

public class PwChangeOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		HttpSession session = request.getSession();
		Integer userNo = (Integer) session.getAttribute("resetUserNo");
		
		if (userNo == null) {
			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/user/password-find.usr");
			return result;
		}
		
		// 서버에서 비번 검사 한번 더 진행
		String userPw = request.getParameter("userPw");
		String userPwCheck = request.getParameter("userPwCheck");

		if(userPw == null || userPwCheck == null || !userPw.equals(userPwCheck)) {
		    request.setAttribute("error", "비밀번호가 일치하지 않습니다.");
		    result.setRedirect(false);
		    result.setPath("/app/user/find-idpassword/password-reset.jsp");
		    return result;
		}
		
		userDTO.setUserNo(userNo);
		userDTO.setUserPw(userPw);

		userDAO.updatePw(userDTO);

		session.removeAttribute("resetUserNo");

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/user/login.usr");
		return result;
	}

}
