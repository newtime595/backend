package com.oulim.app.admin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.admin.dto.AdminCompanyCertificationDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;


public class AdminDownloadCertController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
		String strUserNo = request.getParameter("userNo");
		int userNo = Integer.valueOf(strUserNo);
		AdminCompanyCertificationDTO userCert = adminDAO.getCertUserDetail(userNo);
		
		String systemName = userCert.getOrganFileSystemName();
		String originName = userCert.getOrganFileOriginalName();
		
		if(systemName == null || systemName.trim().isEmpty() ||
				   originName == null || originName.trim().isEmpty()) {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일을 찾을 수 없습니다.");
			return null;
		}
		String uploadPath = request.getServletContext().getRealPath("/upload");
		File file = new File(uploadPath, systemName);
		
		if(!file.exists() || !file.isFile()) {
	        response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일을 찾을 수 없습니다.");
			return null;
		}
		
		String mimeType = request.getServletContext().getMimeType(file.getName());
		if(mimeType==null) {
			mimeType="application/octet-stream";
		}
		
		String encodename = URLEncoder.encode(originName, "UTF-8").replaceAll("\\+", "%20");
		
		response.reset();
		response.setContentType(mimeType);
		response.setContentLengthLong(file.length());
		response.setHeader("Content-Disposition","inline; filename*=UTF-8''" + encodename);
		
		try ( 
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bufferIn = new BufferedInputStream(fis);
			ServletOutputStream servStream = response.getOutputStream();
			BufferedOutputStream  bufferOut = new BufferedOutputStream(servStream);
			){
			byte[] buffer = new byte[8192];
			int read;
			while((read = bufferIn.read(buffer)) != -1) {
				bufferOut.write(buffer,0,read);			
			}
			bufferOut.flush();
		}

		return result;
	}

}
