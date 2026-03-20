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

		Integer organNo = (Integer) session.getAttribute("organNo");
		String organName = (String) session.getAttribute("organName");
		VolunActivityDTO volunActivityDTO = new VolunActivityDTO();

		volunActivityDTO.setVolunActTitle(request.getParameter("volunActTitle"));
		volunActivityDTO.setVolunActRecruBegin(request.getParameter("volunActRecruBegin"));
		volunActivityDTO.setVolunActRecruEnd(request.getParameter("volunActRecruEnd"));
		volunActivityDTO.setVolunActProcBegin(request.getParameter("volunActProcBegin"));
		volunActivityDTO.setVolunActProcEnd(request.getParameter("volunActProcEnd"));
		volunActivityDTO.setVolunActAddress(request.getParameter("volunActAddress"));
		volunActivityDTO.setVolunActAddressDetail(request.getParameter("volunActAddressDetail"));
		volunActivityDTO.setVolunActDetail(request.getParameter("volunActDetail"));
		volunActivityDTO.setVolunActPostnum(request.getParameter("volunActPostnum"));
		volunActivityDTO.setVolunActOrganNo(organNo);
		volunActivityDTO.setVolunActOrginName(organName);
		String point = request.getParameter("volunActPoint");
		String beginTime = request.getParameter("volunActBeginTime");
		String endTime = request.getParameter("volunActEndTime");
		String actType = request.getParameter("volunActActType");
		String ageGroup = request.getParameter("volunActAgeGroup");
		String maxCount = request.getParameter("volunActRecruMaxCount");
		
		System.out.println(volunActivityDTO);
		try {
			volunActivityDTO.setVolunActPoint(Integer.parseInt(point));
			volunActivityDTO.setVolunActBeginTime(Integer.parseInt(beginTime));
			volunActivityDTO.setVolunActEndTime(Integer.parseInt(endTime));
			volunActivityDTO.setVolunActActType(Integer.parseInt(actType));
			volunActivityDTO.setVolunActAgeGroup(Integer.parseInt(ageGroup));
			volunActivityDTO.setVolunActRecruMaxCount(Integer.parseInt(maxCount));
		} catch (NumberFormatException | NullPointerException e) {
			request.setAttribute("errorMessage", "숫자 또는 선택 항목을 다시 확인해주세요.");
			request.setAttribute("volunteer", volunActivityDTO);
			result.setRedirect(false);
			result.setPath("/app/volunteer-manage/volunteer-manage-register.jsp");
			return result;
		}

		try {
			VolunManageInsertService service = new VolunManageInsertService();
			service.insertVolunteer(volunActivityDTO);

			result.setRedirect(true);
			result.setPath(request.getContextPath() + "/volunteer-manage/list.vm");
		} catch (IllegalArgumentException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("volunteer", volunActivityDTO);
			result.setRedirect(false);
			result.setPath("/app/volunteer-manage/volunteer-manage-register.jsp");
		} catch (Exception e) {
			request.setAttribute("errorMessage", "등록 중 오류가 발생했습니다.");
			request.setAttribute("volunteer", volunActivityDTO);
			result.setRedirect(false);
			result.setPath("/app/volunteer-manage/volunteer-manage-register.jsp");
		}

		return result;
	}
}