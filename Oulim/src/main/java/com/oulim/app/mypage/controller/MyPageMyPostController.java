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

        if (userNo == null) {
            result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
            result.setRedirect(true);
            return result;
        }

        // 현재 페이지
        String temp = request.getParameter("page");
        int page = (temp == null) ? 1 : Integer.parseInt(temp);

        int rowCount = 10; // 한 페이지 게시글 수
        int startRow = (page - 1) * rowCount + 1;
        int endRow = page * rowCount;

        Map<String, Object> map = new HashMap<>();
        map.put("startRow", startRow);
        map.put("endRow", endRow);
        map.put("userNo", userNo);

        List<MyPageJoinDTO> mypost = mypageDAO.viewMyPost(map);
        int total = mypageDAO.getMyPostTotal(userNo);

        boolean showPagination = total > rowCount; // 10개 이하이면 숨김

        // 페이지 블록 단위
        int pageCount = 5; 
        int startPage = ((page - 1) / pageCount) * pageCount + 1;
        int endPage = startPage + pageCount - 1;

        int realEndPage = (int)Math.ceil(total / (double)rowCount);
        if (endPage > realEndPage) endPage = realEndPage;

        boolean prev = startPage > 1;  // 이전 블록
        boolean next = endPage < realEndPage; // 다음 블록

        boolean hasPrevPage = page > 1; // 이전 페이지
        boolean hasNextPage = page < realEndPage; // 다음 페이지

        // JSP 전달
        request.setAttribute("mypost", mypost);
        request.setAttribute("total", total);
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("showPagination", showPagination);
        request.setAttribute("hasPrevPage", hasPrevPage);
        request.setAttribute("hasNextPage", hasNextPage);

        result.setPath("/app/mypage/community-history/myposts.jsp");
        result.setRedirect(false);
        return result;
    }
}