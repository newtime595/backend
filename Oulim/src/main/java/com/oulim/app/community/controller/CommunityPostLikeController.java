package com.oulim.app.community.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dto.PostLikeDTO;

public class CommunityPostLikeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CommunityPostLikeController 진입");
		Result result = new Result();
		CommunityDAO commuDAO = new CommunityDAO();
		PostLikeDTO postLikeDTO = new PostLikeDTO();
		int postNo = Integer.valueOf(request.getParameter("postNo"));
		postLikeDTO.setPostNo(postNo);
		postLikeDTO.setUserNo(Integer.valueOf(request.getParameter("userNo")));

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		boolean isSuccess = false;
		try
		{
			commuDAO.doPostLike(postLikeDTO);
			isSuccess = true;
			
		}catch(Exception e) {
			isSuccess = false;
		}
		
		try(PrintWriter out = response.getWriter()){
			out.print("{\"success\" : " + isSuccess + "}");
			out.flush();
		}
		
		result.setPath(null);
		result.setRedirect(false);
		
		return result;
	}	
}
