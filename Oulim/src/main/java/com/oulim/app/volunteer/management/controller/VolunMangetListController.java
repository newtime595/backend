package com.oulim.app.volunteer.management.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

		// Integer organNo = (Integer) request.getSession().getAttribute("organNo");
		Integer organNo = 1; // 테스트용

		String actType = request.getParameter("actType");
		String recruitStatus = request.getParameter("recruitStatus");
		String keyword = request.getParameter("keyword");

		String pageParam = request.getParameter("page");
		int page = 1;

		if (pageParam != null && !pageParam.equals("")) {
			page = Integer.parseInt(pageParam);
		}

		int rowCount = 10;
		int endRow = page * rowCount;
		int startRow = endRow - (rowCount - 1);

		volunActivityDTO.setVolunActOrganNo(organNo);
		volunActivityDTO.setActType(actType);
		volunActivityDTO.setRecruitStatus(recruitStatus);
		volunActivityDTO.setKeyword(keyword);

		int totalCount = volunteerManagementDAO.selectVolManageCount(volunActivityDTO);
		int lastPage = (totalCount + rowCount - 1) / rowCount;

		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("volunActOrganNo", organNo);
		pageMap.put("actType", actType);
		pageMap.put("recruitStatus", recruitStatus);
		pageMap.put("keyword", keyword);
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		List<VolunActivityDTO> list = volunteerManagementDAO.selectVolManagePage(pageMap);

		request.setAttribute("volunteerList", list);
		request.setAttribute("page", page);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("lastPage", lastPage);

		request.setAttribute("actType", actType);
		request.setAttribute("recruitStatus", recruitStatus);
		request.setAttribute("keyword", keyword);

		result.setPath("/app/volunteer-management/volunteer-manage-list.jsp");
		result.setRedirect(false);

		return result;
	}
}