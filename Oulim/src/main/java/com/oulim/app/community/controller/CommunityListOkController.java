package com.oulim.app.community.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.DefineType;
import com.oulim.app.community.dao.CommunityDAO;
import com.oulim.app.community.dto.CommunityPostJoinDTO;

public class CommunityListOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("communityListOk Controller");
		CommunityDAO commuDAO = new CommunityDAO();
		Result result = new Result();

		String searchType = request.getParameter("searchType");
		String keyword = request.getParameter("keyword");

		
		// 페이징 처리
		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp);
		if(page <1) page = 1;

		int startRow = (page - 1) * DefineType.ROWCOUNT_PER_PAGE + 1;
		int endRow = startRow + DefineType.ROWCOUNT_PER_PAGE - 1;

		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("searchType", searchType);
		pageMap.put("keyword", keyword);


		// 게시글 목록 조회
		List<CommunityPostJoinDTO> postList = commuDAO.selectList(pageMap);
		request.setAttribute("postList", postList);


		request.setAttribute("searchType", searchType);
		request.setAttribute("keyword", keyword);
		
		Map<String,Object> searchMap = new HashMap<>();
		searchMap.put("searchType", searchType);
		searchMap.put("keyword", keyword);
		System.out.println("searchMap" + searchMap);
		int total = commuDAO.getPostTotal(searchMap);
		System.out.println("게시글 총 갯수 : " + total); 
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

		System.out.println("페이징 확인");
		System.out.println("pageMap : " + pageMap);
		System.out.println("boardList : " + postList);
		System.out.println(
				"startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("=========================");
		
		result.setPath("/app/community/community-list.jsp");
		result.setRedirect(false);
		return result;
	}

}
