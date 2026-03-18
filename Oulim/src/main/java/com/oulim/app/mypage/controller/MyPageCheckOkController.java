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

public class MyPageCheckOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;
		
		Integer userNo = (Integer) session.getAttribute("userNo");
		
		String userPw = request.getParameter("userPw");
		String userPw2 = (String)mypageDAO.enterMyPage1(userNo);
		
		
		
		if(userNo == null) {
			path = "/app/mypage/check/check.jsp"; // 일단 내 페이지로 > 테스트용
			result.setPath(path);
			result.setRedirect(true);
			return result;
		} 
		
		
		
		if(userPw == userPw2) {
			
			result.setPath("/app/mypage/profile/profile.jsp");
			result.setRedirect(true);
			return result;
			
		}
		
		
		return result;
		
		
	}

}
