package com.oulim.app.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dao.CommunityFileDAO;
import com.oulim.app.community.dto.CommunityPostDTO;
import com.oulim.app.community.dto.PostImageDTO;

public class CommunityWriteOKController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CommunityWriteOkController 실행");
		CommunityPostDTO postDTO = new CommunityPostDTO();
		CommunityDAO commuDAO = new CommunityDAO();
		CommunityFileDAO commuFileDAO = new CommunityFileDAO();
		Result result = new Result();
		
		// 로그인 회원 정보
		Integer userNo = (Integer)request.getSession().getAttribute("userNo");
		String userNickname = (String)request.getSession().getAttribute("userNickname");		
		System.out.println("현재 로그인한 유저번호 : " + userNo);
		System.out.println("현재 로그인한 유저닉네임 : " + userNickname);
		
		if(userNo == null) {
			System.out.println("오류 : 로그인 중인 사용자가 없습니다");
			response.sendRedirect("/app/user/login/login.jsp");
			return null;
		}
		
		if(userNickname == null) {
			System.out.println("오류 : 사용자 닉네임이 없습니다");
			response.sendRedirect("index.jsp");
			return null;
		}
		
		// 파일 업로드 환경 설정
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/")+"upload/";
		final int FILE_SIZE = 1024 * 1024 * 5;
		
		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);
		File uploadDir = new File(UPLOAD_PATH);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
	      //MultipartRequest를 이용한 데이터 파싱
	      MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8", 
	            new DefaultFileRenamePolicy()); 
		
	      postDTO.setPostTitle(multipartRequest.getParameter("postTitle"));
	      postDTO.setPostContent(multipartRequest.getParameter("postContent"));
	      postDTO.setUserNo(userNo);
	      postDTO.setUserNickname(userNickname);
	      System.out.println("게시글 추가 - postJoinDTO : " + postDTO);
	      
	      // 게시글 추가
	      int postNo = commuDAO.insertCommunityPost(postDTO);
	      System.out.println("생성된 게시글 번호 : " + postNo);
	      
	      // 파일 업로드
	      Enumeration<String> fileNames = multipartRequest.getFileNames();
	      while(fileNames.hasMoreElements()) {
	    	  PostImageDTO postImgDTO = new PostImageDTO();
	    	  String name = fileNames.nextElement();
	    	  String fileSystemName = multipartRequest.getFilesystemName(name);
	    	  String fileOriginalName = multipartRequest.getOriginalFileName(name);
	    	  
	    	  if(fileSystemName == null) {
	    		  continue;
	    	  }
	    	  
	    	  postImgDTO.setPostImgSystemName(fileSystemName);
	    	  postImgDTO.setPostImgOriginName(fileOriginalName);
	    	  postImgDTO.setPostNo(postNo);
	    	  
	    	  System.out.println("업로드 파일 정보 : " + postImgDTO);
	    	  commuFileDAO.insert(postImgDTO);
	      }
	      
	      result.setPath("/community/list.commu");
	      result.setRedirect(true);
	      
		return result;
	}
	
}
