package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dto.VolunActivityDTO;
import com.oulim.app.volunteer.management.service.VolunManageInsertService;

public class VolunManageInsertOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		HttpSession session = request.getSession();
		VolunManageInsertService service = new VolunManageInsertService();
		Integer organNo = 1; // 테스트
		// Integer organNo = (Integer) session.getAttribute("organNo");

		VolunActivityDTO dto = new VolunActivityDTO();
		dto.setVolunActTitle(request.getParameter("volunActTitle"));
		dto.setVolunActRecruBegin(request.getParameter("volunActRecruBegin"));
		dto.setVolunActRecruEnd(request.getParameter("volunActRecruEnd"));
		dto.setVolunActProcBegin(request.getParameter("volunActProcBegin"));
		dto.setVolunActProcEnd(request.getParameter("volunActProcEnd"));
		dto.setVolunActAddress(request.getParameter("volunActAddress"));
		dto.setVolunActDetail(request.getParameter("volunActDetail"));
		dto.setVolunActOrganNo(organNo);

		String point = request.getParameter("volunActPoint");
		String beginTime = request.getParameter("volunActBeginTime");
		String endTime = request.getParameter("volunActEndTime");
		String actType = request.getParameter("volunActActType");
		String ageGroup = request.getParameter("volunActAgeGroup");
		String maxCount = request.getParameter("volunActRecruMaxCount");

		try {
			if (point != null && !point.trim().isEmpty()) {
				dto.setVolunActPoint(Integer.parseInt(point));
			}
			if (beginTime != null && !beginTime.trim().isEmpty()) {
				dto.setVolunActBeginTime(Integer.parseInt(beginTime));
			}
			if (endTime != null && !endTime.trim().isEmpty()) {
				dto.setVolunActEndTime(Integer.parseInt(endTime));
			}
			if (actType != null && !actType.trim().isEmpty()) {
				dto.setVolunActActType(Integer.parseInt(actType));
			}
			if (ageGroup != null && !ageGroup.trim().isEmpty()) {
				dto.setVolunActAgeGroup(Integer.parseInt(ageGroup));
			}
			if (maxCount != null && !maxCount.trim().isEmpty()) {
				dto.setVolunActRecruMaxCount(Integer.parseInt(maxCount));
			}
		} catch (NumberFormatException e) {
			request.setAttribute("errorMessage", "숫자 항목은 숫자만 입력해주세요.");
			request.setAttribute("volunteer", dto);
			result.setRedirect(false);
			result.setPath("/app/volunteer-manage/volunteer-manage-register.jsp");
			return result;
		}
		
		try {
			service.insertVolunteer(dto);

			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/volunteer-manage/list.vm");
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("volunteer", dto);
			result.setRedirect(false);
			result.setPath("/app/volunteer-manage/volunteer-manage-register.jsp");
		}

		return result;
	}
}