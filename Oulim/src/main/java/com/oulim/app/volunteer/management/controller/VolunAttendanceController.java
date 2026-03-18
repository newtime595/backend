package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dto.PointJoinDTO;
import com.oulim.app.volunteer.management.service.VolunManageServicePoint;

public class VolunAttendanceController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		PointJoinDTO pointJoinDTO = new PointJoinDTO();

		int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));
		String[] userNos = request.getParameterValues("attendanceUser");

		VolunManageServicePoint volunmanageservicepoint= new VolunManageServicePoint();

		if (userNos != null && userNos.length > 0) {
			VolunManageServicePoint.attendanceProcess(pointJoinDTO, userNos);
		}

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/volunteer-manage/detail.vm?volunActNo=" + volunActNo);

		return result;
	}

}
