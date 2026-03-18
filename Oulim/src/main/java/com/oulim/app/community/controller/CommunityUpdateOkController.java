package com.oulim.app.community.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dao.CommunityFileDAO;
import com.oulim.app.community.dto.CommunityPostDTO;
import com.oulim.app.community.dto.PostImageDTO;

public class CommunityUpdateOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CommunityDAO commuDAO = new CommunityDAO();
		CommunityPostDTO commuDTO = new CommunityPostDTO();
		CommunityFileDAO commuFileDAO = new CommunityFileDAO();
		Result result = new Result();
		
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		final int FILE_SIZE = 1024 * 1024 * 5;
		
		// MultiPartParser 실행
		MultipartParser parser = new MultipartParser(request,FILE_SIZE);
		parser.setEncoding("utf-8");
		System.out.println("MultipartParser 초기화 완료");
		
		int postNo = 0;
		boolean isFileUpload = false;
		
		Part part;
		while((part = parser.readNextPart()) != null) {
			System.out.println("Part : " + part.getClass().getSimpleName());
			
			if(part.isParam()) {
				ParamPart paramPart = (ParamPart) part;
				String paramName = paramPart.getName();
				String paramValue = paramPart.getStringValue();
				
				if("postNo".equals(paramName)) {
					postNo = Integer.parseInt(paramValue);
					commuDTO.setPostNo(postNo);
				}else if("postTitle".equals(paramName)) {
					commuDTO.setPostTitle(paramValue);
				}else if("postContent".equals(paramName)) {
					commuDTO.setPostContent(paramValue);
				}				
			}else if(part.isFile() && !isFileUpload) {
				FilePart filePart = (FilePart) part;
				filePart.setRenamePolicy(new DefaultFileRenamePolicy());
				String fileOriginalName = filePart.getFileName();
				
				if(postNo != 0) {
					List<PostImageDTO> existingFiles = commuFileDAO.select(postNo);
					for(PostImageDTO image : existingFiles) {
						File oldFile = new File(UPLOAD_PATH, image.getPostImgSystemName());
						if(oldFile.exists()) {
							System.out.println("기존 파일 삭제 : " + oldFile.getAbsolutePath());
							oldFile.delete();
						}
					}
					commuFileDAO.delete(postNo);
					System.out.println("기본 파일 db삭제 완료");
				}
				// 새로운 파일 저장
				if(fileOriginalName != null) {
					String newFileName = System.currentTimeMillis() + "_" + fileOriginalName;
					File newFile = new File(UPLOAD_PATH, newFileName);
					filePart.writeTo(newFile);
					if(newFile.exists()) {
						System.out.println("새로운 파일 저장 완료 : " + newFile.getAbsolutePath());
					}else {
						System.out.println("신규 파일 저장 실패 : " + newFile.getAbsolutePath());
					}
					
					// 새 파일 정보를 db 저장
					PostImageDTO postImageDTO = new PostImageDTO();
					postImageDTO.setPostImgSystemName(newFileName);
					postImageDTO.setPostImgOriginName(fileOriginalName);
					postImageDTO.setPostNo(postNo);
					System.out.println("새로운 파일 확인 : " + postImageDTO);
					commuFileDAO.insert(postImageDTO);
					System.out.println("새로운 파일 DB 저장 완료 : " + postImageDTO);
					
					isFileUpload = true;
				}else {
					System.out.println("업로드된 파일이 없습니다");
				}
			}
			
		}
		// 게시물 업데이트 실행
		commuDTO.setUserNo((Integer)request.getSession().getAttribute("userNo"));
		commuDAO.repostPost(commuDTO);
		System.out.println("게시글 수정 완료");
		
		result.setPath("/community/detail.commu?postNo=" + commuDTO.getPostNo());
		result.setRedirect(true);
		return result;
	}
	
}
