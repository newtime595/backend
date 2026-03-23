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

public class MyPageUpdatePwController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();

		Integer userNo = (Integer) session.getAttribute("userNo");
		String newPw = request.getParameter("new-pw");
		String newPwCheck = request.getParameter("new-pw-check");

		System.out.println("newPw: " + newPw);
		System.out.println("newPwCheck: " + newPwCheck);
		
		if (userNo == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}

		if (newPw == null || newPw.trim().isEmpty() || !newPw.equals(newPwCheck)) {
			result.setPath(request.getContextPath() + "/mypage/organEdit.mp");
			result.setRedirect(true);
			return result;
		}

		MyPageJoinDTO myPageJoinDTO = new MyPageJoinDTO();
		myPageJoinDTO.setUserNo(userNo);
		myPageJoinDTO.setUserPw(newPw);

		mypageDAO.updatePw(myPageJoinDTO);
		
		result.setPath(request.getContextPath() + "/mypage/organEdit.mp?pwStatus=success");
		result.setRedirect(true);

		return result;
	}
}