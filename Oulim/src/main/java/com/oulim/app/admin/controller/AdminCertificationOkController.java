package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminCertificationOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		String strUserNo = request.getParameter("userNo");
		int userNo = Integer.valueOf(strUserNo);
		String strIsApprove = request.getParameter("isApprove");
		boolean isApprove = strIsApprove.equals("true") ? true : false;
		boolean queryResult = false;
		if(isApprove) {
			String strOrganNo = request.getParameter("organNo");
			int organNo = Integer.valueOf(strOrganNo);
			Map<String, Integer> userMap = new HashMap<>();
			userMap.put("userNo", userNo);
			userMap.put("organNo", organNo);
			
			queryResult = adminDAO.approveOrganUser(userMap);
		}else {
			queryResult = adminDAO.deleteOrganUser(userNo);
		}
		
		result.setPath("/admin/companycertification.adm");
		result.setRedirect(true);
		return result;
	}

}
