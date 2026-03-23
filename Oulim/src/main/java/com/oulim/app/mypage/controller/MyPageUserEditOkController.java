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

public class MyPageUserEditOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		MyPageJoinDTO mypageDTO = new MyPageJoinDTO();
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");
		Integer userType = (Integer) session.getAttribute("userType");

		if (request.getSession().getAttribute("userNo") == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}		
			
		// 파라미터 받기
		String nickname = request.getParameter("userNickname");
		String email = request.getParameter("userEmail");
		String password = request.getParameter("newPassword");
		String passwordChk = request.getParameter("confirmPassword");
		
		if (password != null && !password.trim().isEmpty()) {
			System.out.println("비밀번호 변경 조건문 통과");
			mypageDTO.setUserPw(password);
		}
		
		
		// DTO 세팅
		mypageDTO.setUserNo(userNo);
		mypageDTO.setUserNickname(nickname);
		mypageDTO.setUserEmail(email);

		
		session.setAttribute("userNickname", nickname);

		// 이메일 인증 관련 세션 제거
		session.removeAttribute("emailAuthCode");
		session.removeAttribute("emailAuthEmail");
		session.removeAttribute("emailAuthTime");
		session.removeAttribute("emailVerified");

		// 성공 메시지
		
		

		// DAO 호출
		mypageDAO.userEdit(mypageDTO);

		session.setAttribute("editSuccess", "회원정보가 수정되었습니다. 비밀번호를 재입력해주세요.");
		result.setPath(request.getContextPath() + "/mypage/checkOk.mp");
		result.setRedirect(true);
		return result;
	}

}
