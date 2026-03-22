package com.oulim.app.admin.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.admin.dto.AdminMemListDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminMemListController implements Execute {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        Result result = new Result();
        AdminMemDAO adminMemDAO = new AdminMemDAO();
        AdminMemListDTO dto = new AdminMemListDTO();

        System.out.println("회원 목록 진입");

        String searchType = request.getParameter("searchType");
        String keyword = request.getParameter("keyword");

 
        int page = 1;
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 1;
		}
		if (page < 1) {
			page = 1;
		}

		
        int rowCount = 10;
        int pageCount = 10;
        int startRow = (page - 1) * rowCount + 1;
        int endRow = startRow + rowCount - 1;

        dto.setSearchType(searchType);
        dto.setKeyword(keyword);
        dto.setStartRow(startRow);
        dto.setEndRow(endRow);

        List<AdminMemListDTO> memberList = adminMemDAO.selectList(dto);

        int total = adminMemDAO.selectCount(dto);
        int realEndPage = (int)Math.ceil(total / (double)rowCount);
        int endPage = (int)(Math.ceil(page / (double)pageCount) * pageCount);
        int startPage = endPage - (pageCount - 1);
        endPage = Math.min(endPage, realEndPage);

        request.setAttribute("memberList", memberList);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", startPage > 1);
        request.setAttribute("next", endPage < realEndPage);
        request.setAttribute("searchType", searchType);
        request.setAttribute("keyword", keyword);
        request.setAttribute("queryString", buildQuery(searchType, keyword));

        result.setPath("/app/admin/jsp/member-manage/mem-list.jsp");
        result.setRedirect(false);
        return result;
    }

    private String buildQuery(String searchType, String keyword) throws IOException {
        StringBuilder builder = new StringBuilder();
        if (searchType != null && !searchType.isEmpty()) {
            builder.append("&searchType=").append(URLEncoder.encode(searchType, "UTF-8"));
        }
        if (keyword != null && !keyword.isEmpty()) {
            builder.append("&keyword=").append(URLEncoder.encode(keyword, "UTF-8"));
        }
        return builder.toString();
    }
}
