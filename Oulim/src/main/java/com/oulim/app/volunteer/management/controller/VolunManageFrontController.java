package com.oulim.app.volunteer.management.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Result;

/**
 * Servlet implementation class VolunteerMangementFrontController
 */
public class VolunManageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunManageFrontController() {
        super();
    }

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
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println("VolunteerMangementFrontController 현재 경로 : " + target);
		Result result = new Result();
		
		switch(target) {
		case "/volunteer-manage/list.vm":
			System.out.println("봉사관리 리스트 페이지 요청");
			result = new VolunMangetListController().execute(request, response);
			System.out.println("봉사관리 리스트 완료");
			break;
			
		case "/volunteer-manage/register.vm":
			System.out.println("봉사관리 등록 페이지 요청");
			result = new VolunManageInsertController().execute(request, response);
			System.out.println("봉사관리 등록 페이지 완료");
			break;
		
		case "/volunteer-manage/registerOk.vm":
			System.out.println("봉사관리 등록 요청");
			result = new VolunManageInsertOkController().execute(request, response);
			System.out.println("봉사관리 등록 완료");
			break;
			
		case "/volunteer-manage/detail.vm":
			System.out.println("봉사관리 상세 페이지 요청");
			result = new VolunManageDetailController().execute(request, response);
			System.out.println("봉사관리 상세 페이지 완료");
			break;
			
		case "/volunteer-manage/update.vm":
			System.out.println("봉사관리 수정 페이지 요청");
			result = new VolunManageUpdateController().execute(request, response);
			System.out.println("봉사관리 수정 페이지 완료");
			break;

		case "/volunteer-manage/updateOk.vm":
			System.out.println("봉사관리 수정 요청");
			result = new VolunManageUpdateOkController().execute(request, response);
			System.out.println("봉사관리 수정 완료");
			break;
			
		case "/volunteer-manage/delete.vm":
			System.out.println("봉사관리 삭제 요청");
			result = new VolunManageDeleteController().execute(request, response);
			System.out.println("봉사관리 삭제 완료");
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
