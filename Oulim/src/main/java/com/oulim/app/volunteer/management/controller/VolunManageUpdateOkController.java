package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunManageUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VolunteerMangementDAO volunteerMangementDAO = new VolunteerMangementDAO();
		VolunActivityDTO volunActivityDTO = new VolunActivityDTO();
		Result result = new Result();

		volunActivityDTO.setVolunActNo(Integer.parseInt(request.getParameter("volunActNo")));
		volunActivityDTO.setVolunActTitle(request.getParameter("volunActTitle"));
		volunActivityDTO.setVolunActRecruBegin(request.getParameter("volunActRecruBegin"));
		volunActivityDTO.setVolunActRecruEnd(request.getParameter("volunActRecruEnd"));
		volunActivityDTO.setVolunActProcBegin(request.getParameter("volunActProcBegin"));
		volunActivityDTO.setVolunActProcEnd(request.getParameter("volunActProcEnd"));
		volunActivityDTO.setVolunActPoint(Integer.parseInt(request.getParameter("volunActPoint")));
		volunActivityDTO.setVolunActBeginTime(Integer.parseInt(request.getParameter("volunActBeginTime")));
		volunActivityDTO.setVolunActEndTime(Integer.parseInt(request.getParameter("volunActEndTime")));
		volunActivityDTO.setVolunActActType(Integer.parseInt(request.getParameter("volunActActType")));
		volunActivityDTO.setVolunActAgeGroup(Integer.parseInt(request.getParameter("volunActAgeGroup")));
		volunActivityDTO.setVolunActAddress(request.getParameter("volunActAddress"));
		volunActivityDTO.setVolunActAddressDetail(request.getParameter("volunActAddressDetail"));
		volunActivityDTO.setVolunActPostnum(request.getParameter("volunActPostnum"));
		volunActivityDTO.setVolunActRecruMaxCount(Integer.parseInt(request.getParameter("volunActRecruMaxCount")));
		volunActivityDTO.setVolunActDetail(request.getParameter("volunActDetail"));

		volunteerMangementDAO.volManageUpdate(volunActivityDTO);

		result.setPath(request.getContextPath() + "/volunteer-manage/detail.vm?volunActNo=" + volunActivityDTO.getVolunActNo());
		result.setRedirect(true);

		return result;
	}

}
