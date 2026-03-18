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

public class LoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPw");
		HttpSession session = request.getSession(); //+++ 세션저장
		String path = null;
		
		userDTO.setUserId(userId);
		userDTO.setUserPw(userPassword);
		System.out.println(userDTO);
		
		//쿼리문 실행 메소드 호출
		UserDTO loginUser = userDAO.login(userDTO);
		
		if (loginUser != null) {
			// 세션 저장
			session.setAttribute("userNo", loginUser.getUserNo());
			session.setAttribute("userNickname", loginUser.getUserNickname());
			session.setAttribute("userType", loginUser.getUserType());
			
			System.out.println("userNo : " + loginUser.getUserNo());
			System.out.println("userNickname : " + loginUser.getUserNickname());
			System.out.println("userType : " + loginUser.getUserType());

			path = "/index.jsp"; // 성공 후 이동 경로 수정
			
		} else {
			path = "/user/login.usr?login=fail";
		}
		
		result.setRedirect(true); //세션에 저장된 값은 유지
		result.setPath(path);
		
		
		return result;
	}

}
