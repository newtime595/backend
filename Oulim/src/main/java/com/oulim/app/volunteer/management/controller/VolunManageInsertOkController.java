package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunManageInsertOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("봉사 등록 처리 컨트롤러 이동 완료");
		VolunteerMangementDAO volunteerMangementDAO = new VolunteerMangementDAO();
		VolunActivityDTO volunActivityDTO = new VolunActivityDTO();
		Result result = new Result();
		HttpSession session = request.getSession();
		
//		Integer organNo = (Integer) session.getAttribute("organNo");
		Integer organNo=1;	//테스트
		
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
		volunActivityDTO.setVolunActOrganNo(organNo);
		volunActivityDTO.setVolunActAddress(request.getParameter("volunActAddress"));
		volunActivityDTO.setVolunActRecruMaxCount(Integer.parseInt(request.getParameter("volunActRecruMaxCount")));
		volunActivityDTO.setVolunActDetail(request.getParameter("volunActDetail"));

		volunteerMangementDAO.volActivityInsert(volunActivityDTO);
		result.setPath(request.getContextPath() + "/volunteer-manage/list.vm");
		result.setRedirect(true);
		
		return result;
	}

}
