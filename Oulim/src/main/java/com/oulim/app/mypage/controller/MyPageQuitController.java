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

public class MyPageQuitController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		MyPageJoinDTO mypageJoinDTO = new MyPageJoinDTO();
		HttpSession session = request.getSession();
		
		Integer userNo = (Integer) session.getAttribute("userNo");
		Integer userType = (Integer) session.getAttribute("userType");
		System.out.println("유저 타입 " + userType);
		String userPw = request.getParameter("userPw");
		
	      if(request.getSession().getAttribute("userNo") == null) {
	          result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
	          result.setRedirect(true);
	          return result;
	       }

		if (userType != 1) {
			System.out.println("기업 마이페이지 진입 조건 통과");
			result.setPath("/app/mypage-organ/quit/quit.jsp");
			result.setRedirect(false);
			return result;
		}
		
		result.setPath("/app/mypage/quit/quit.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
