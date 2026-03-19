package com.oulim.app.volunteer.activity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Result;


public class VolunActFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolunActFrontController() {
        super();
        // TODO Auto-generated constructor stub
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

 	// 핵심 로직 분리
 	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 		String target = request.getRequestURI().substring(request.getContextPath().length());
 		System.out.println("VolunActFrontController 경로 : " + target);
 		Result result = new Result();

 		switch (target) {
 		case "/volunteer-activity/list.va":
 			System.out.println("봉사 조회 리스트 요청");
 			result = new VolunActListController().execute(request, response);
 			System.out.println("봉사 조회 리스트 완료");
 			break;
//작업전
// 		case "/volunteer-activity/detail.va":
// 			System.out.println("봉사 상세 요청");
// 			result = new VolunActDetailController().execute(request, response);
// 			System.out.println("봉사 상세 완료");
// 			break;
//
// 		default:
// 			System.out.println("잘못된 경로: " + target);
// 			break;
 		}

 		// View 이동 처리
 		if (result != null && result.getPath() != null) {
 			if (result.isRedirect()) {
 				response.sendRedirect(request.getContextPath() + result.getPath());
 			} else {
 				request.getRequestDispatcher(result.getPath()).forward(request, response);
 			}
 		}
 	}
 }