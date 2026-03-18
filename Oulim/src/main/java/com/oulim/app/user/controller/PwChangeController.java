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

public class PwChangeController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDTO userDTO = new UserDTO();
        UserDAO userDAO = new UserDAO();
        Result result = new Result();
        
        userDTO.setUserId(request.getParameter("userId"));
        userDTO.setUserName(request.getParameter("userName"));
        userDTO.setUserBirth(request.getParameter("userBirth"));
        userDTO.setUserEmail(request.getParameter("userEmail"));
        
        UserDTO findUser = userDAO.findPw(userDTO);

		if (findUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("resetUserNo", findUser.getUserNo());
			result.setPath("/app/user/find-idpassword/password-reset.jsp");
		} else {
			request.setAttribute("error", "일치하는 회원정보가 없습니다.");
			result.setPath("/app/user/find-idpassword/password-find.jsp");
		}

		result.setRedirect(false);
		return result;
	}

}
