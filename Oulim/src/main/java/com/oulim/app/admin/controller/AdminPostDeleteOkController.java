package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminPostDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminPostDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		AdminPostDAO adminPostDAO = new AdminPostDAO();
		
	 System.out.println("게시글 삭제 요청 진입");
		
	 int postNo = Integer.parseInt(request.getParameter("postNo"));
	 
	 System.out.println(postNo);
		adminPostDAO.deleteCommunityPost(postNo);
		
		result.setPath("/admin/postList.adm");
		result.setRedirect(true);
		
		return result;
	}

	
	
}
