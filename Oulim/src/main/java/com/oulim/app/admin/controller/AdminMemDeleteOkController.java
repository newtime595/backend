package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminMemDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

        AdminMemDAO adminMemDAO = new AdminMemDAO();
        Result result = new Result();

        int userNo = Integer.parseInt(request.getParameter("userNo"));

        adminMemDAO.delete(userNo);

        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/admin/memList.adm");

        return result;
	}

}
