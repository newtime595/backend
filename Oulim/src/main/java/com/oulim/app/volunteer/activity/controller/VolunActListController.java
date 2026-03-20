package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dao.VolunteerActivityDAO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunActListController implements Execute {

	private int parseIntSafe(String param) {
		if (param == null || param.trim().equals("") || param.trim().equals("0")) {
			return 0;
		}
		return Integer.parseInt(param.trim());
	}

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		VolunteerActivityDAO dao = new VolunteerActivityDAO();
		VolunActivityDTO dto = new VolunActivityDTO();

		String actType = request.getParameter("volunActActType");
		String ageGroup = request.getParameter("volunActAgeGroup");
		String recruitStatus = request.getParameter("recruitStatus");
		String keyword = request.getParameter("keyword");
		String searchType = request.getParameter("searchType");
		String organization = request.getParameter("organization");

		dto.setVolunActActType(parseIntSafe(actType));
		dto.setVolunActAgeGroup(parseIntSafe(ageGroup));
		dto.setRecruitStatus(recruitStatus == null ? "0" : recruitStatus.trim());
		dto.setKeyword(keyword == null ? "" : keyword.trim());
		dto.setSearchType(searchType == null ? "title" : searchType.trim());
		dto.setOrganization(organization == null ? "" : organization.trim());

		int page = parseIntSafe(request.getParameter("page"));
		if (page == 0)
			page = 1;

		int size = 10;

		int totalCount = dao.selectCount(dto);
		int totalPage = (int) Math.ceil((double) totalCount / size);

		int pageBlock = 5;
		int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
		int endPage = Math.min(startPage + pageBlock - 1, totalPage);

		int startRow = (page - 1) * size;
		int endRow = page * size;

		dto.setStartRow(startRow);
		dto.setEndRow(endRow);

		List<VolunActivityDTO> list = dao.selectVolActList(dto);

		request.setAttribute("volunteerList", list);
		request.setAttribute("search", dto);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);

		Result result = new Result();
		result.setPath("/app/volunteer-activity/volunAct-list.jsp");
		result.setRedirect(false);

		return result;
	}
}