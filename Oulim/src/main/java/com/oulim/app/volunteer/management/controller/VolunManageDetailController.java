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
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class VolunManageDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VolunteerMangementDAO volunteerMangementDAO = new VolunteerMangementDAO();
		Result result = new Result();

		int volunActNo = Integer.parseInt(request.getParameter("volunActNo"));

		String pageParam = request.getParameter("page");
		int page = 1;

		if (pageParam != null && !pageParam.equals("")) {
			page = Integer.parseInt(pageParam);
		}

		int rowCount = 10;
		int endRow = page * rowCount;
		int startRow = endRow - (rowCount - 1);

		int totalCount = volunteerMangementDAO.selectApplyCount(volunActNo);
		int lastPage = (totalCount + rowCount - 1) / rowCount;

		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("volunActNo", volunActNo);
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);

		VolunActivityDTO volunDetail = volunteerMangementDAO.selectVolManageDetail(volunActNo);
		List<VolunApplyDTO> applyList = volunteerMangementDAO.applyVolSelectPage(pageMap);

		request.setAttribute("volunDetail", volunDetail);
		request.setAttribute("applyList", applyList);

		request.setAttribute("page", page);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("lastPage", lastPage);

		result.setPath("/app/volunteer-management/volunteer-manage-detail.jsp");
		result.setRedirect(false);

		return result;
	}

}
