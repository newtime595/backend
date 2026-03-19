package com.oulim.app.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;

public class MyPageUserEditController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();

		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");
		
	      if(request.getSession().getAttribute("userNo") == null) {
	          result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
	          result.setRedirect(true);
	          return result;
	       }
		
		mypageDAO.userAllinfo(userNo);
		mypageDAO.organAdditionalinfo(userNo);
		
		path = "/app/mypage/profile/profile-edit.jsp";
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}

}
