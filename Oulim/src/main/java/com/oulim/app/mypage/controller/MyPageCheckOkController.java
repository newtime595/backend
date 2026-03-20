package com.oulim.app.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageCheckOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();

		Integer userNo = (Integer) session.getAttribute("userNo");
		Integer userType = (Integer) session.getAttribute("userType");

		String userPw = request.getParameter("userPw");

		System.out.println("userNo : " + userNo);
		System.out.println("userType : " + userType);
		System.out.println("입력 비밀번호 : " + userPw);

		if (userNo == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}

		if (mypageDAO.enterMyPage(userNo)) {
			
			if (userType != null && userType == 2) {
				// 기업회원일 때
				System.out.println("2번진입@@@@@@@@@@@@@@");
				result.setPath("/app/mypage-organ/profile/profile-edit.jsp");
				result.setRedirect(false);
				return result;
			} else {
				// 일반회원일 때
				MyPageJoinDTO summaryInfo = mypageDAO.summaryInfo(userNo);
				MyPageJoinDTO finVolunInfo = mypageDAO.miniFinVol(userNo);
				List<MyPageJoinDTO> pointInfo = mypageDAO.miniPoint(userNo);
				MyPageJoinDTO comVolunInfo = mypageDAO.miniComVol(userNo);

				request.setAttribute("miniPoint", pointInfo);

				request.setAttribute("totalVolunTime", summaryInfo.getTotalVolunTime());
				request.setAttribute("rankPoint", summaryInfo.getRankPoint());
				request.setAttribute("totalAmount", summaryInfo.getTotalAmount());
				request.setAttribute("volunActNo", summaryInfo.getVolunActNo());

				request.setAttribute("comVolunActTitle", comVolunInfo.getVolunActTitle());
				request.setAttribute("comVolunActProcEnd", comVolunInfo.getComVolunActProcEnd());
				request.setAttribute("comVolunActProcBegin", comVolunInfo.getComVolunActProcBegin());

				request.setAttribute("finVolunActTitle", finVolunInfo.getVolunActTitle());
				request.setAttribute("finVolunActProcEnd", finVolunInfo.getFinVolunActProcEnd());
				request.setAttribute("finVolunActProcBegin", finVolunInfo.getFinVolunActProcBegin());

				result.setPath("/app/mypage/profile/profile.jsp");
				result.setRedirect(false);
				return result;
			}
		}

		// 비밀번호 틀렸을 때
		if (userType != null && userType == 2) {
			result.setPath(request.getContextPath() + "/mypage-organ/check.mp");
		} else {
			result.setPath(request.getContextPath() + "/mypage/check.mp");
		}
		result.setRedirect(true);

		return result;
	}
}