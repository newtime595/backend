package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;

public class AdminPostDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		CommunityDAO communityDAO = new CommunityDAO();
		
		System.out.println("게시글 상세 진입");
		
        int postNo = Integer.parseInt(request.getParameter("postNo"));
        request.setAttribute("post", communityDAO.selectPostDetail(postNo));
		System.out.println(communityDAO.selectPostDetail(postNo));
        Map<String, Integer> pageMap = new HashMap<>();
        pageMap.put("postNo", postNo);
        pageMap.put("startRow", 1);
        pageMap.put("endRow", 100);
        request.setAttribute("commentList", communityDAO.selectCommentList(pageMap));
		
		
		
		result.setPath("/app/admin/jsp/community-manage/post-detail.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
}
