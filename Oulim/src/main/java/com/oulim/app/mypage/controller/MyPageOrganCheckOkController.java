package com.oulim.app.mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageOrganCheckOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();

		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");

		String userPw = request.getParameter("userPw");

		System.out.println(userNo);

		if (request.getSession().getAttribute("userNo") == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}

		Map<String, Object> userMap = new HashMap<>();
		userMap.put("userNo", userNo);
		userMap.put("userPw", userPw);
		
		boolean isCorrect = mypageDAO.enterMyPage(userMap);

		if (isCorrect) {
		    result.setPath("/mypage/organEdit.mp");
		    result.setRedirect(true);
		} else {
		    result.setPath("/app/mypage-organ/check/check.jsp");
		    result.setRedirect(false);
		}

		return result;
	}

}
