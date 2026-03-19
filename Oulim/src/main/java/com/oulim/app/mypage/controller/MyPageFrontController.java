package com.oulim.app.mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Result;

/**
 * Servlet implementation class MyPageFrontController
 */
public class MyPageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String requestURI = request.getRequestURI();              
		String contextPath = request.getContextPath();           
		String target = requestURI.substring(contextPath.length()); 

		System.out.println("UserFrontController 실행");
		System.out.println("URI : " + requestURI);
		System.out.println("Target : " + target);

		Result result = new Result();
		
		switch(target) {
		
		case "/mypage/check.mp":
			System.out.println("마이페이지 진입");
			result = new MyPageCheckController().execute(request, response);
			break;
			
		case "/mypage/checkOk.mp":
			System.out.println("마이페이지 진입 성공");
			result = new MyPageCheckOkController().execute(request, response);
			break;
			
		case "/mypage/userEdit.mp": // 일반회원 정보 수정
			result = new MyPageUserEditController().execute(request, response);
			break;

		case "/mypage/userEditOk.mp": // 일반회원 정보 수정 ok
			result = new MyPageUserEditOkController().execute(request, response);
			break;
			
		case "/mypage/organEdit.mp": // 기업회원 정보 수정
			result = new MyPageOrganEditController().execute(request, response);
			break;

		case "/mypage/organEditOk.mp": // 기업회원 정보 수정 ok
			result = new MyPageOrganEditOkController().execute(request, response);
			break;
			
		case "/mypage/comingVolun.mp": // 예정된 봉사 목록 조회
			result = new MyPageComingVolunController().execute(request, response);
			break;
		
		case "/mypage/finishVolun.mp": // 완료한 봉사 목록 조회
			result = new MyPageFinishVolunController().execute(request, response);
			break;
			
		case "/mypage/point.mp":
			result = new MyPagePointController().execute(request, response);
			break;
			
		case "/mypage/myPost.mp": // 나의 작성 글 조회
			System.out.println("작성글 조회 페이지 요청");
			result = new MyPageMyPostController().execute(request, response);
			break;
			
		case "/mypage/quit.mp": // 회원탈퇴
			System.out.println("회원탈퇴 처리 요청");
			result = new MyPageQuitController().execute(request, response);
			break;

		case "/mypage/quitOk.mp": // 회원탈퇴 ok
			System.out.println("회원탈퇴 처리 완료");
			result = new MyPageQuitOkController().execute(request, response);
			break;
		
		}
		
		if(result != null && result.getPath() != null) {
			if(result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	
	
	}

}
