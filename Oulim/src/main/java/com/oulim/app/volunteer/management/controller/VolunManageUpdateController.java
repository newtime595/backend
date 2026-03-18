package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunManageUpdateController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VolunteerMangementDAO volunteerMangementDAO = new VolunteerMangementDAO();
		Result result = new Result();
		
		int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));

		VolunActivityDTO volunActivityDTO = volunteerMangementDAO.selectVolManageUpdate(volunActNo);

		request.setAttribute("volunActivity", volunActivityDTO);

		result.setPath("/app/volunteer-management/volunteer-manage-edit.jsp");
		result.setRedirect(false);

		return result;
	}

}
