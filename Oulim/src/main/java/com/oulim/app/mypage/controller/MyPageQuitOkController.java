package com.oulim.app.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageQuitOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		MyPageJoinDTO mypageJoinDTO = new MyPageJoinDTO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");

		String userPw = request.getParameter("userPw");
//		String userPw2 = (String)mypageDAO.enterMyPage1(userNo);

		System.out.println(userNo);

		if (userNo == null) {
			System.out.println("세션번호 부재 오류");
			path = "/app/mypage/check/check.jsp"; // 일단 내 페이지로 > 테스트용
			result.setPath(path);
			result.setRedirect(true);
			return result;
		}

		if (session != null) {

			if (mypageDAO.enterMyPage(userNo)) {
				System.out.println("비밀번호 일치 조건문 진입 성공");
				path = "/app/mypage/check/check.jsp"; // 테스트 일단 내 페이지로
				mypageDAO.quit(userNo);
				System.out.println("쿼리문 실행 완료");

				session.invalidate(); // 세션 전체 삭제
			}


			result.setPath(path);
			result.setRedirect(false);

			return result;
		}

		return null;
	}
}
