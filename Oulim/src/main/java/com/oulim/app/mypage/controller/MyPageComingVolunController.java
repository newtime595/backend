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

public class MyPageComingVolunController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();

		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");
		
		List<MyPageJoinDTO> comingVolun = mypageDAO.comingVolun(userNo); // 맵으로 바꿔야함
		
//		if(comingVolun != null) {
			path = "/app/mypage/volunteer-history/coming-volunteer.jsp";
			result.setPath(path);
			result.setRedirect(false);
//		}
		
		request.setAttribute("comingVolun", comingVolun);
		

		return result;
	}

}
