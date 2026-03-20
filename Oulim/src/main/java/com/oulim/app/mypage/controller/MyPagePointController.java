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

public class MyPagePointController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Result result = new Result();
        HttpSession session = request.getSession();
        Integer userNo = (Integer) session.getAttribute("userNo");

        if (userNo == null) {
            result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
            result.setRedirect(true);
            return result;
        }

        String tab = request.getParameter("tab");
        if (tab == null) tab = "plus"; // 기본은 적립 포인트

        String plusTemp = request.getParameter("plusPage");
        String minusTemp = request.getParameter("minusPage");

        int plusPage = (plusTemp == null) ? 1 : Integer.parseInt(plusTemp);
        int minusPage = (minusTemp == null) ? 1 : Integer.parseInt(minusTemp);

        int rowCount = 10;

        MyPageJoinDAO dao = new MyPageJoinDAO();

        // 적립 포인트
        int plusTotal = dao.plusTotal(userNo);
        int plusLastPage = (int) Math.ceil(plusTotal / (double) rowCount);

        Map<String, Object> plusMap = new HashMap<>();
        plusMap.put("startRow", (plusPage - 1) * rowCount + 1);
        plusMap.put("endRow", plusPage * rowCount);
        plusMap.put("userNo", userNo);
        List<MyPageJoinDTO> plusPoint = dao.plusPoint(plusMap);

        // 사용 포인트
        int minusTotal = dao.minusTotal(userNo);
        int minusLastPage = (int) Math.ceil(minusTotal / (double) rowCount);

        Map<String, Object> minusMap = new HashMap<>();
        minusMap.put("startRow", (minusPage - 1) * rowCount + 1);
        minusMap.put("endRow", minusPage * rowCount);
        minusMap.put("userNo", userNo);
        List<MyPageJoinDTO> minusPoint = dao.minusPoint(minusMap);

        if (plusLastPage == 0) plusLastPage = 1;
        if (minusLastPage == 0) minusLastPage = 1;

        // JSP 전달
        request.setAttribute("activeTab", tab);
        request.setAttribute("plusPage", plusPage);
        request.setAttribute("plusLastPage", plusLastPage);
        request.setAttribute("minusPage", minusPage);
        request.setAttribute("minusLastPage", minusLastPage);
        request.setAttribute("plusPoint", plusPoint);
        request.setAttribute("minusPoint", minusPoint);
        
        
        request.setAttribute("postNo", request.getParameter("postNo"));

        int total = tab.equals("plus") ? plusTotal : minusTotal;
        
        request.setAttribute("total", total);
        
        System.out.println("minusTotal = " + minusTotal);
        System.out.println("minusLastPage = " + minusLastPage);
        System.out.println("minusPage = " + minusPage);

        result.setPath("/app/mypage/point-history/point-history.jsp");
        result.setRedirect(false);
        return result;
    }
}