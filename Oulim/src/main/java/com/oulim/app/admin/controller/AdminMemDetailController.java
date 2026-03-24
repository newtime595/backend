package com.oulim.app.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminMemDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) {

		Result result = new Result();
	    AdminMemDAO adminMemDAO = new AdminMemDAO();
	
	    String userNoStr = request.getParameter("userNo");
	
	    if(userNoStr != null && !userNoStr.isEmpty()) {
	        int userNo = Integer.parseInt(userNoStr);
	        request.setAttribute("member", adminMemDAO.selectDetail(userNo));
	    }
	
	    result.setPath("/app/admin/jsp/member-manage/mem-detail.jsp");
	    result.setRedirect(false);
	
	    return result;
	}
}
