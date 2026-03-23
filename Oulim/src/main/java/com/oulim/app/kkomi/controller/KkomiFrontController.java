package com.oulim.app.kkomi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.DefineType;

/**
 * Servlet implementation class KkomiFrontController
 */
public class KkomiFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KkomiFrontController() {
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
		String target = request.getRequestURI().substring(request.getContextPath().length());
		Result result = null;

		if (request.getSession().getAttribute("userType") == null
				|| (Integer) request.getSession().getAttribute("userType") != DefineType.NORMAL_USER_TYPE) {
			result = new Result();
			result.setPath("/index.jsp");
			result.setRedirect(true);
		} else {
			switch (target) {
			case "/kkomi/info.kko" -> {
				System.out.println("꼬미 정보 조회");
				result = new KkomiInfoController().execute(request, response);
				System.out.println("꼬미 정보 조회 완료");
			}
			case "/kkomi/feed.kko" -> {
				System.out.println("꼬미 도력 쌓기");
				result = new KkomiUpdateController().execute(request, response);
				System.out.println("꼬미 도력 쌓기 완료");
			}
			case "/kkomi/ranking.kko" -> {
				System.out.println("랭킹 페이지 진입");
				result = new RankingListController().execute(request, response);
				System.out.println("랭킹 페이지 진입 완료");
			}
			case "/kkomi/mission.kko" -> {
				System.out.println("미션 페이지 진입");
				result = new MissionListOkController().execute(request, response);
				System.out.println("미션 페이지 진입 완료");
			}
			case "/kkomi/storage.kko" -> {

			}

			}
		}
		if (result != null && result.getPath() != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
	}

}
