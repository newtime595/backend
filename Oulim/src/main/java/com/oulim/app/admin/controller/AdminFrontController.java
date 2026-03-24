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
		
		case "/admin/memList.adm":
			System.out.println("회원 목록 요청");
			result = new AdminMemListController().execute(request, response);
			break;	

		case "/admin/memDetail.adm":
			System.out.println("회원 상세 요청");
			result = new AdminMemDetailController().execute(request, response);
			break;	
		
		case "/admin/memEdit.adm":
			System.out.println("회원 수정페이지 요청");
			result = new AdminMemEditController().execute(request, response);
			break;	
			
		case "/admin/volunlist.adm":
			System.out.println("봉사 목록 요청");
			result = new AdmVolManController().execute(request, response);
			break;	

		case "/admin/volundetail.adm":
			System.out.println("봉사 상세 요청");
			result = new AdmVolManDetaController().execute(request, response);
			break;	
			
		case "/admin/postList.adm":
			System.out.println("게시판 목록 요청");
			result = new AdminPostListController().execute(request, response);
			break;	

		case "/admin/postDetail.adm":
			System.out.println("게시글 상세 요청");
			result = new AdminPostDetailController().execute(request, response);
			break;	

		case "/admin/postDeleteok.adm":
			System.out.println("게시글 삭제 요청");
			result = new AdminPostDeleteOkController().execute(request, response);
			break;	
			
		case "/admin/companycertification.adm":
			System.out.println("신청 기업 목록 요청");
			result = new AdminCompanyCertificationController().execute(request, response);
			break;	

		case "/admin/companydetail.adm":
			System.out.println("기업 상세 요청");
			result = new AdminCompanyDetailController().execute(request, response);
			break;	
			
		case "/admin/compCertOk.adm":
			System.out.println("기업 회원 승인/반려 요청");
			result = new AdminCertificationOkController().execute(request, response);
			break;
		case "/admin/viewCert.adm":
			System.out.println("파일보기/다운로드");
			result = new AdminDownloadCertController().execute(request, response);
			break;		
		case "/admin/mailSend.adm":
			System.out.println("메일 보내기 요청");
			result = new AdminMailSendController().execute(request, response);
			break;
			
		case "/admin/memUpdateOk.adm":
			System.out.println("유저정보 편집 페이지 요청");
			result = new AdminMemUpdateOkController().execute(request, response);
			break;		
		}

		if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(request.getContextPath() + result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}
}
