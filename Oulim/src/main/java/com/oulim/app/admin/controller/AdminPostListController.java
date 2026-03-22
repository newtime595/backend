package com.oulim.app.admin.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dto.CommunityPostJoinDTO;

public class AdminPostListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Result result = new Result();
		CommunityDAO communityDAO = new CommunityDAO();
		
		System.out.println("관리자 게시글 목록 페이지 이동");
		
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

		
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("searchType", searchType);
		pageMap.put("keyword", keyword);
		
		
		
		List<CommunityPostJoinDTO> postList = communityDAO.selectList(pageMap);

		int total = communityDAO.getPostTotal();

		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		endPage = Math.min(endPage, realEndPage);
		
		request.setAttribute("postList", postList);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", startPage > 1);
		request.setAttribute("next", endPage < realEndPage);
		request.setAttribute("searchType", searchType);
		request.setAttribute("keyword", keyword);
		request.setAttribute("queryString", buildQuery(searchType, keyword));
		
		
		
		result.setPath("/app/admin/jsp/community-manage/post-list.jsp");
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
