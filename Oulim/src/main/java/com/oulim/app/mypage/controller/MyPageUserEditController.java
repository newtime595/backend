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

public class MyPageUserEditController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");
		Integer userType = (Integer) session.getAttribute("userType");
		
		
	      if(request.getSession().getAttribute("userNo") == null) {
	          result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
	          result.setRedirect(true);
	          return result;
	       }
		
	     if(userType != 1) {
	    	 mypageDAO.organAdditionalinfo(userNo);
	     }
	      
	     MyPageJoinDTO mypageDTO = mypageDAO.userAllinfo(userNo);
		
	     request.setAttribute("userEmail", mypageDTO.getUserEmail());
	     request.setAttribute("userNickname", mypageDTO.getUserNickname());

		
		path = "/app/mypage/profile/profile-edit.jsp";
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}

}
