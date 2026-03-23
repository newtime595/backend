package com.oulim.app.user.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class OrganJoinFirstOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		Result result = new Result();
		
		Boolean emailVerified = (Boolean) request.getSession().getAttribute("emailVerified");

		if (emailVerified == null || !emailVerified) {
			throw new ServletException("이메일 인증이 완료되지 않았습니다.");
		}
		
		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "upload/";
		final int FILE_SIZE = 1024 * 1024 * 5;
		
		File uploadDir = new File(UPLOAD_PATH);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH,FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());
		
		String organName = multipartRequest.getParameter("organName");
		String userName = multipartRequest.getParameter("userName");
		String userBirth = multipartRequest.getParameter("userBirth");
		String organCertNum = multipartRequest.getParameter("organCertNum");
		String userEmail = multipartRequest.getParameter("userEmail");
		
		String fileSystemName = multipartRequest.getFilesystemName("certFile");
		String fileOriginalName = multipartRequest.getOriginalFileName("certFile");

		if (fileSystemName == null || fileOriginalName == null) {
			request.getSession().setAttribute("joinError", "PDF 파일은 필수입니다.");
		    result.setPath(request.getContextPath() + "/user/organJoinFirst.usr");
		    result.setRedirect(true);
		    return result;
		}

		if (!fileOriginalName.toLowerCase().endsWith(".pdf")) {
			File wrongFile = new File(UPLOAD_PATH, fileSystemName);
			if (wrongFile.exists()) {
				wrongFile.delete();
			}
			request.getSession().setAttribute("joinError", "PDF 파일만 업로드 가능합니다.");
			result.setPath(request.getContextPath() + "/user/organJoinFirst.usr");
			result.setRedirect(true);
			return result;
		}

		String newSystemName = UUID.randomUUID().toString() + ".pdf";
		File oldFile = new File(UPLOAD_PATH, fileSystemName);
		File newFile = new File(UPLOAD_PATH, newSystemName);

		if (oldFile.exists()) {
			oldFile.renameTo(newFile);
		}
		
		request.setAttribute("organName", organName);
		request.setAttribute("userName", userName);
		request.setAttribute("userBirth", userBirth);
		request.setAttribute("organCertNum", organCertNum);
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("organFileSystemName", newSystemName);
		request.setAttribute("organFileOriginalName", fileOriginalName);

		
		result.setPath("/app/user/signin/signup-info-company.jsp");
		result.setRedirect(false);

		return result;
	}

}
