package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.admin.dto.AdminCompanyCertificationDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminCompanyDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		String strUserNo = request.getParameter("userNo");
		int userNo = Integer.valueOf(strUserNo);
		
		AdminCompanyCertificationDTO admCompCertDetail = adminDAO.getCertUserDetail(userNo);
		System.out.println(admCompCertDetail );
		request.setAttribute("userDetail", admCompCertDetail);
		
		result.setPath("/app/admin/jsp/member-manage/company-detail.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
}
