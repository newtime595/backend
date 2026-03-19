package com.oulim.app.mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageMyPostController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    Result result = new Result();
	    MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
	    HttpSession session = request.getSession();

	    Integer userNo = (Integer) session.getAttribute("userNo");

	    // 로그인 체크
	    if (userNo == null) {
	        result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
	        result.setRedirect(true);
	        return result;
	    }

	    String temp = request.getParameter("page");
	    int page = (temp == null) ? 1 : Integer.valueOf(temp);
	    if (page < 1) page = 1;

	    int rowCount = 10;
	    int pageCount = 10;

	    int startRow = (page - 1) * rowCount + 1;
	    int endRow = startRow + rowCount - 1;

	    Map<String, Object> pageMap = new HashMap<>();
	    pageMap.put("startRow", startRow);
	    pageMap.put("endRow", endRow);
	    pageMap.put("userNo", userNo);

	    List<MyPageJoinDTO> mypost = mypageDAO.viewMyPost(pageMap);
	    request.setAttribute("mypost", mypost);

	    int total = mypageDAO.getMyPostTotal(userNo);

	    int realEndPage = (int) Math.ceil(total / (double) rowCount);
	    int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
	    int startPage = endPage - (pageCount - 1);

	    endPage = Math.min(endPage, realEndPage);

	    boolean prev = startPage > 1;
	    boolean next = endPage < realEndPage;

	    request.setAttribute("page", page);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("prev", prev);
	    request.setAttribute("next", next);
	    request.setAttribute("total", total);
	    

	    result.setPath("/app/mypage/community-history/myposts.jsp");
	    result.setRedirect(false);

	    return result;
	}

}
