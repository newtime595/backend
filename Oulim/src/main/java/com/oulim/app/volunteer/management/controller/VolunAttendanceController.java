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
		VolunManageServicePoint volunManageServicePoint = new VolunManageServicePoint();
		
		String[] userNos = request.getParameterValues("attendanceUser");
		int changeAmount = Integer.parseInt(request.getParameter("changeAmount"));
		int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));
		int attendanceStatus = Integer.parseInt(request.getParameter("attendanceStatus"));
		
		
		pointJoinDTO.setChangeAmount(changeAmount);

		if (userNos != null && userNos.length > 0) {
			volunManageServicePoint.attendanceProcess(pointJoinDTO, userNos, volunActNo, attendanceStatus);
		}

		result.setRedirect(true);
		result.setPath(request.getContextPath() + "/volunteer-manage/detail.vm?volunActNo=" + volunActNo);

		return result;
	}
}