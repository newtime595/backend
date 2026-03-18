package com.oulim.app.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.user.dao.UserDAO;

public class CommunityWriteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("게시글 작성 페이지 컨트롤러 이동 완료");
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
		Integer userNo = (Integer)session.getAttribute("userNo");
		String userNickname = (String)session.getAttribute("userNickname");
		String path = null;
		
		if(userNo == null) {
			path = "/app/user/login/login.jsp";
		}else {
			path = "/app/community/community-post.jsp";
//			request.setAttribute("userNo",userDAO);
			request.setAttribute("userNickname", userNickname);
		}
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}
	
}
