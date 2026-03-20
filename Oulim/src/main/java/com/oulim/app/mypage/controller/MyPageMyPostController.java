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


		String activeTab = request.getParameter("tab");
		if (activeTab == null || (!activeTab.equals("plus") && !activeTab.equals("minus"))) {
			activeTab = "plus";
		}

		// 탭별 페이지
		int plusPage = 1;
		int minusPage = 1;

		if ("plus".equals(activeTab)) {
			String temp = request.getParameter("page");
			plusPage = (temp == null) ? 1 : Integer.parseInt(temp);
		} else {
			String temp = request.getParameter("page");
			minusPage = (temp == null) ? 1 : Integer.parseInt(temp);
		}

		// rowCount
		int rowCount = 10;

		// 적립 포인트 조회
		Map<String, Object> plusMap = new HashMap<>();
		plusMap.put("startRow", (plusPage - 1) * rowCount + 1);
		plusMap.put("endRow", plusPage * rowCount);
		plusMap.put("userNo", userNo);
		List<MyPageJoinDTO> plusPoint = mypageDAO.plusPoint(plusMap);
		int plusTotal = mypageDAO.plusTotal(userNo);
		int plusLastPage = (int) Math.ceil(plusTotal / (double) rowCount);

		// 사용 포인트 조회
		Map<String, Object> minusMap = new HashMap<>();
		minusMap.put("startRow", (minusPage - 1) * rowCount + 1);
		minusMap.put("endRow", minusPage * rowCount);
		minusMap.put("userNo", userNo);
		List<MyPageJoinDTO> minusPoint = mypageDAO.minusPoint(minusMap);
		int minusTotal = mypageDAO.minusTotal(userNo);
		int minusLastPage = (int) Math.ceil(minusTotal / (double) rowCount);

		// JSP 전달
		request.setAttribute("activeTab", activeTab);
		request.setAttribute("plusPoint", plusPoint);
		request.setAttribute("minusPoint", minusPoint);
		request.setAttribute("plusLastPage", plusLastPage);
		request.setAttribute("minusLastPage", minusLastPage);
		request.setAttribute("plusPage", plusPage);
		request.setAttribute("minusPage", minusPage);

		result.setPath("/app/mypage/community-history/myposts.jsp");
		result.setRedirect(false);

		return result;
	}

}
