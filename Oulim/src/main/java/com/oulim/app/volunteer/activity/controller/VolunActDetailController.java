package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		VolunteerActivityDAO dao = new VolunteerActivityDAO();
		

		int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));
		VolunActivityDTO volunActivityDTO = dao.selectDetail(volunActNo);

		request.setAttribute("volunActivity", volunActivityDTO);

		result.setPath("/app/volunteer-activity/volunAct-detail.jsp");
		result.setRedirect(false);
		
		
		
		return result;
	}

}
