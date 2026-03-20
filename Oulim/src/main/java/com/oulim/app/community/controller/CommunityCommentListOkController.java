package com.oulim.app.community.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.oulim.app.community.dto.CommunityCommentDTO;

public class CommunityCommentListOkController implements Execute{

	private String escapeJson(String str) {
		if (str == null) return "";
		return str.replace("\\", "\\\\")
				  .replace("\"", "\\\"")
				  .replace("\n", "\\n")
				  .replace("\r", "\\r")
				  .replace("\t", "\\t");
	}

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CommunityDAO commuDAO = new CommunityDAO();

		int postNo = Integer.valueOf(request.getParameter("postNo"));
		int page = Integer.valueOf(request.getParameter("page"));
		
		
		int totalComment = commuDAO.getTotalComment(postNo);
	    
		int startRow = (page - 1) * DefineType.ROWCOUNT_PER_PAGE + 1;
		int endRow = startRow + DefineType.ROWCOUNT_PER_PAGE - 1;
		Map<String, Integer> rowMap = new HashMap<>();
		rowMap.put("postNo", postNo);
		rowMap.put("startRow", startRow);
		rowMap.put("endRow", endRow);
		
		   // 댓글 가져오기
	    List<CommunityCommentDTO> commentList = commuDAO.selectCommentList(rowMap);
	    
	    int realEndPage = (int)Math.ceil(totalComment / (double)DefineType.ROWCOUNT_PER_PAGE);
	    if(realEndPage == 0) {
	    	realEndPage = 1;
	    }		int endPage = (int) (Math.ceil(page / (double) DefineType.MAX_PAGE_COUNT) * DefineType.MAX_PAGE_COUNT);
	    
		int startPage = endPage - (DefineType.MAX_PAGE_COUNT - 1);
		if(startPage < 1) {
			startPage = 1;
		}
		endPage = Math.min(endPage,  realEndPage);
		
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");		
		
		
		try(PrintWriter out = response.getWriter()){
			StringBuilder json = new StringBuilder();
			json.append("{");
			// 페이지 정보
			json.append("\"page\":").append(page).append(",");
			json.append("\"startPage\":").append(startPage).append(",");
			json.append("\"endPage\":").append(endPage).append(",");
			json.append("\"prev\":").append(prev).append(",");
			json.append("\"next\":").append(next).append(",");

			// 댓글 리스트
			json.append("\"commentList\":[");

			for(int i = 0 ; i < commentList.size(); i++) {
				CommunityCommentDTO comment = commentList.get(i);
				json.append("{");
			    json.append("\"userNickname\":\"").append(escapeJson(comment.getUserNickname())).append("\",");
			    json.append("\"commentContent\":\"").append(escapeJson(comment.getCommentContent())).append("\",");
			    json.append("\"postDate\":\"").append(escapeJson(comment.getPostDate())).append("\"");
			    json.append("}");
			    if (i < commentList.size() - 1) {
			        json.append(",");
			    }
			}
			json.append("]");
			json.append("}");
			
			out.write(json.toString());
			out.flush();
		}
		
		
		
		return null;
	}

}
