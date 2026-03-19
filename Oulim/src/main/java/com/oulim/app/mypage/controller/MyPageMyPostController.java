package com.oulim.app.mypage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageMyPostController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Result result = new Result();

		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");
		
		System.out.println("작성글 조회 쿼리 실행 전");
		
		List<MyPageJoinDTO> mypost = mypageDAO.viewMyPost(userNo);

		System.out.println("작성 글 조회 쿼리 실행");
//		if (mypost != null) {
			path = "/app/mypage/community-history/myposts.jsp";
			result.setPath(path);
			result.setRedirect(false);
//		}

		return result;
	}

}
