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

public class MyPageComingVolunController implements Execute {
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

		// 페이지 번호
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		int rowCount = 10;

		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("userNo", userNo);
		pageMap.put("startRow", (page - 1) * rowCount + 1);
		pageMap.put("endRow", page * rowCount);

		MyPageJoinDAO dao = new MyPageJoinDAO();
		List<MyPageJoinDTO> comingVol = dao.comingVolunPage(pageMap);
		int totalCount = dao.comingVolunTotal(userNo);
		int lastPage = (int) Math.ceil(totalCount / (double) rowCount);

		request.setAttribute("comingVol", comingVol);
		request.setAttribute("page", page);
		request.setAttribute("lastPage", lastPage);

		result.setPath("/app/mypage/volunteer-history/coming-volunteer.jsp");
		result.setRedirect(false);
		return result;
	}
}