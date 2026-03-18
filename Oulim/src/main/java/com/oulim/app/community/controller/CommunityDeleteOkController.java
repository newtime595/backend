package com.oulim.app.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dao.CommunityFileDAO;
import com.oulim.app.community.dto.PostImageDTO;

public class CommunityDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===CommunityDeleteOkController===");
		
		CommunityDAO commuDAO = new CommunityDAO();
		CommunityFileDAO commuFileDAO = new CommunityFileDAO();
		Result result = new Result();
		
		int postNo = Integer.parseInt(request.getParameter("postNo"));
		
		// 업로드 경로
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		
		List<PostImageDTO> images = commuFileDAO.select(postNo);
		
		for(PostImageDTO image : images) {
			File target = new File(UPLOAD_PATH, image.getPostImgSystemName());
			
			if(target.exists()) {
				target.delete();
			}
		}
		
		// 파일 DB 삭제
		commuFileDAO.delete(postNo);
		
		// 게시물 삭제
		commuDAO.deleteCommunityPost(postNo);
		
		result.setPath("/community/list.commu");
		result.setRedirect(true);
		return result;
	}

}
