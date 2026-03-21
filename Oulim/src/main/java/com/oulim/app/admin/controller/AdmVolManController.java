package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdmVolMangDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class AdmVolManController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdmVolMangDAO dao = new AdmVolMangDAO();
		VolunActivityDTO dto = new VolunActivityDTO();
		dto.setStartRow(1);
		dto.setEndRow(100); // 테스트니까 넉넉하게
		
		
		List<VolunActivityDTO> list = dao.selectAdminVolunList(dto);
		System.out.println("리스트 개수: " + list.size());
		request.setAttribute("volunList", list);
		
		Result result = new Result();
		result.setPath("/app/admin/jsp/volunteer-manage/volun-list.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
