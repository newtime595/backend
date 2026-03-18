package com.oulim.app.volunteer.management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerMangementDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunMangetListController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("===VolunteerMangementListController 실행===");
		VolunteerMangementDAO volunteerManagementDAO = new VolunteerMangementDAO();
		VolunActivityDTO volunActivityDTO = new VolunActivityDTO();
		Result result = new Result();

//		Integer organNo = (Integer) request.getSession().getAttribute("organNo");		//세션 정보값
		Integer organNo = 1; // 테스트용
		String actType = request.getParameter("actType");
		String recruitStatus = request.getParameter("recruitStatus");
		String keyword = request.getParameter("keyword");
		
		volunActivityDTO.setVolunActOrganNo(organNo);
		volunActivityDTO.setActType(actType);
		volunActivityDTO.setRecruitStatus(recruitStatus);
		volunActivityDTO.setKeyword(keyword);
		
		List<VolunActivityDTO> list = volunteerManagementDAO.selectVolManageList(volunActivityDTO);
		request.setAttribute("volunteerList", list);
		
		result.setPath("/app/volunteer-management/volunteer-manage-list.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
