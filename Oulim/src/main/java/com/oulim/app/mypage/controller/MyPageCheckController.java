package com.oulim.app.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class MyPageCheckController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
	      if(request.getSession().getAttribute("userNo") == null) {
	          result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
	          result.setRedirect(true);
	          return result;
	       }
		
		result.setPath("/app/mypage/check/check.jsp");
		result.setRedirect(false);
		
		
		return result;
	}

}
