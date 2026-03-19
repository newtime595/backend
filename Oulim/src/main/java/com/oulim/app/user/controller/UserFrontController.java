package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();              
		String contextPath = request.getContextPath();           
		String target = requestURI.substring(contextPath.length()); 

		System.out.println("UserFrontController 실행");
		System.out.println("URI : " + requestURI);
		System.out.println("Target : " + target);

		Result result = null;
		Execute execute = null;

		if (target.equals("/user/login.usr")) {
			System.out.println("로그인 페이지 요청");
			execute = new LoginController();

		} else if (target.equals("/user/loginOk.usr")) {
			System.out.println("로그인 처리 요청");
			execute = new LoginOkController();

		} else if (target.equals("/user/logout.usr")) {
			System.out.println("로그아웃 요청");
			execute = new LogoutController();

		} else if (target.equals("/user/normalJoinFirstOk.usr")) {
			System.out.println("일반회원 1차 입력 처리 요청");
			execute = new NormalJoinFirstOkController();

		} else if (target.equals("/user/normalJoinSecondOk.usr")) {
			System.out.println("일반회원 2차 입력 처리 요청");
			execute = new NormalJoinSecondOkController();
			
		}else if (target.equals("/user/organJoinFirstOk.usr")) {
			System.out.println("기업회원 1차 입력 처리 요청");
			execute = new OrganJoinFirstOkController();

		} else if (target.equals("/user/organJoinSecondOk.usr")) {
			System.out.println("기업회원 2차 입력 처리 요청");
			execute = new OrganJoinSecondOkController();
			
		} else if (target.equals("/user/idFindOk.usr")) {
			System.out.println("아이디 찾기 처리 요청");
		    execute = new IdFindController();
		    
		} else if (target.equals("/user/pwFind.usr")) {
		    System.out.println("비밀번호 찾기 확인 요청");
		    execute = new PwChangeController();

		} else if (target.equals("/user/pwChangeOk.usr")) {
		    System.out.println("비밀번호 변경 요청");
		    execute = new PwChangeOkController();
		    
		} else if (target.equals("/user/checkOk.usr")) {
			System.out.println("데이터 중복체크 요청");
		    execute = new CheckOkController();
		    
		} else if(target.equals("/user/sendEmailAuthCode.usr")) {
			execute = new SendEmailAuthCodeController();
			
		} else if(target.equals("/user/verifyEmailAuthCode.usr")) {
			execute = new VerifyEmailAuthCodeController();
		}
		
		if (execute != null) {
			result = execute.execute(request, response);
		}

		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(request.getContextPath() + result.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(result.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}