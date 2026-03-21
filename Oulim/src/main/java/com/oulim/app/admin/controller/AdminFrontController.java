package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Result;

/**
 * Servlet implementation class AdminFrontController
 */

public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String target = requestURI.substring(contextPath.length());

		System.out.println("FrontController 실행");
		System.out.println("URI : " + requestURI);
		System.out.println("Target : " + target);
		Result result = new Result();

		switch (target) {

		case "/admin/login.adm": 
			System.out.println("로그인 페이지 요청");
			result = new AdminLoginController().execute(request, response);
			System.out.println();
			break;
			
		case "/admin/loginOk.adm": 
			System.out.println("로그인 처리요청");
			result = new AdminLoginOkController().execute(request, response);
			break;

		case "/admin/logout.adm":
			System.out.println("로그아웃 요청");
			result = new AdminLogoutController().execute(request, response);
			break;
			
		case "/admin/dashboard.adm":
		    System.out.println("대시보드 요청");
		    result = new AdminDashboardController().execute(request, response);
		    break;	
		
		case "/admin/memlist.adm":
			System.out.println("회원 목록 요청");
			result = new AdminMemListController().execute(request, response);
			break;	

		case "/admin/memdetail.adm":
			System.out.println("회원 상세 요청");
			result = new AdminMemDetailController().execute(request, response);
			break;	
		
		case "/admin/memedit.adm":
			System.out.println("회원 수정페이지 요청");
			result = new AdminMemEditController().execute(request, response);
			break;	
			
		case "/admin/volunlist.adm":
			System.out.println("봉사 목록 요청");
			result = new AdmVolManController().execute(request, response);
			break;	

//		case "/admin/volundetail.adm":
//			System.out.println("봉사 상세 요청");
//			result = new AdminVolunDetailController().execute(request, response);
//			break;	
			
		case "/admin/postlist.adm":
			System.out.println("게시판 목록 요청");
			result = new AdminPostListController().execute(request, response);
			break;	

		case "/admin/postdetail.adm":
			System.out.println("게시글  요청");
			result = new AdminPostDetailController().execute(request, response);
			break;	
		
		case "/admin/companycertification.adm":
			System.out.println("신청 기업 목록 요청");
			result = new AdminCompanyCertificationController().execute(request, response);
			break;	

		case "/admin/companydetail.adm":
			System.out.println("기업 상세 요청");
			result = new AdminCompanyDetailController().execute(request, response);
			break;	
			
			
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
