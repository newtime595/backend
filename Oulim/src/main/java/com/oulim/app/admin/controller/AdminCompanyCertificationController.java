package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.admin.dto.AdminCompanyCertificationDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.DefineType;

public class AdminCompanyCertificationController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		
		if(request.getSession().getAttribute("adminNo") == null) {
			result.setPath("/admin/login.adm");
			result.setRedirect(true);
			return result;
		}
		
		// 페이징 처리
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		if(page <1) page = 1;

		int startRow = (page - 1) * DefineType.ROWCOUNT_PER_PAGE + 1;
		int endRow = startRow + DefineType.ROWCOUNT_PER_PAGE - 1;
		
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		List<AdminCompanyCertificationDTO> admCompCertDTO = adminDAO.getRequireApprovedOrganUser(pageMap);
		int total = adminDAO.getCountUnApprovedOrganUser();
		request.setAttribute("requireMemberList", admCompCertDTO);
		int realEndPage = (int) (Math.ceil(total / (double) DefineType.ROWCOUNT_PER_PAGE));
		int endPage = (int) (Math.ceil(page / (double) DefineType.MAX_PAGE_COUNT) * DefineType.MAX_PAGE_COUNT);
		
		int startPage = endPage - (DefineType.MAX_PAGE_COUNT - 1);
		
		endPage = Math.min(endPage,  realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("totalCount", total);
		
		result.setPath("/app/admin/jsp/member-manage/company-certification.jsp");
		result.setRedirect(false);
		
		return result;
	}

	
}
