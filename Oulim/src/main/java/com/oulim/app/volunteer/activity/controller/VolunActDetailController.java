package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		VolunteerActivityDAO dao = new VolunteerActivityDAO();

		int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));
		VolunActivityDTO volunActivityDTO = dao.selectDetail(volunActNo);

		HttpSession session = request.getSession();
		Integer userNo = (Integer) session.getAttribute("userNo");
		Integer userType = (Integer) session.getAttribute("userType");

		boolean isApplied = false;

		if (userNo != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("volunActNo", volunActNo);
			map.put("userNo", userNo);

			isApplied = dao.selectApplyCount(map) > 0;
		}
		System.out.println(userType);
		request.setAttribute("volunActivity", volunActivityDTO);
		request.setAttribute("isApplied", isApplied);
		request.setAttribute("userType", userType);
		
		result.setPath("/app/volunteer-activity/volunAct-detail.jsp");
		result.setRedirect(false);

		return result;
	}
}