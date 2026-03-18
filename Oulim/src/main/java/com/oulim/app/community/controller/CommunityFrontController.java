package com.oulim.app.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Result;

/**
 * Servlet implementation class CommunityFrontController
 */
public class CommunityFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityFrontController() {
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
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;
		switch(target) {
		case "/community/list.commu" ->{
			System.out.println("봉사후기 조회 입장");
			result = new CommunityListOkController().execute(request, response);
			System.out.println("봉사후기 조회 처리 완료");
		}
		case "/community/post.commu"->{
			System.out.println("봉사후기 등록");
			result = new CommunityWriteController().execute(request, response);
			System.out.println("봉사후기 등록 페이지 이동 완료");
		}
		
		case "/community/rePost.commu" ->{
			System.out.println("게시글 수정");
		}
		
		case "/community/detail.commu" ->{
			System.out.println("봉사후기 상세보기");
			result = new CommunityReadOkController().execute(request, response);
			System.out.println("봉사후기 상세보기 처리 완료");
		}
		case "/community/like.commu"->{
			System.out.println("봉사후기 추천");
		}
		
		case "/community/commentPost.commu"->{
			System.out.println("댓글 등록");
		}
		
		case "/community/postOK.commu" ->{
			System.out.println("후기 등록 성공");
			result = new CommunityWriteOKController().execute(request, response);
			System.out.println("봉사후기 등록 완료");
		}
		
		case "/community/postDelete.commu" ->{
			System.out.println("후기 삭제");
		}
		}
		
		if(result != null && result.getPath() != null) {
			if(result.isRedirect()) {
				response.sendRedirect(result.getPath());
			}else {
				request.getRequestDispatcher(result.getPath()).forward(request,response);
			}
		}
	}

}
