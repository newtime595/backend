package com.oulim.app.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dto.CommunityCommentDTO;

public class CommunityCommentPostOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommunityDAO commuDAO = new CommunityDAO();
		Result result = new Result();

		if(request.getSession().getAttribute("userNo") == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}
		
		Integer userNo = (Integer) request.getSession().getAttribute("userNo");
		if(userNo == null) {
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write("{\"success\": false}");
			return null;
		}
		String userNickname = (String) request.getSession().getAttribute("userNickname");
		
		CommunityCommentDTO commentDTO = new CommunityCommentDTO();
		int postNo = Integer.valueOf(request.getParameter("postNo"));
		String commentText = request.getParameter("content");
		if(commentText.getBytes("UTF-8").length > 500) {
	    	  System.out.println("댓글 최대 글자 수 초과");
	    	  request.setAttribute("msg", "contentSizeOver");
	    	  result.setPath("/community/detail.commu?postNo="+postNo);
	    	  result.setRedirect(false);
	    	  return result;
	      }
		
		commentDTO.setPostNo(postNo);
		commentDTO.setUserNickname(userNickname);
		commentDTO.setUserNo(userNo);
		commentDTO.setCommentContent(commentText);
		
		commuDAO.insertPostComment(commentDTO);
		
		result.setPath(null);
		result.setRedirect(false);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write("{\"success\": true}");
		
		return result;
	}

}
