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

public class MyPageProfileController implements Execute{
	
	
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		MyPageJoinDTO mypageJoinDTO = new MyPageJoinDTO();
		HttpSession session = request.getSession();
		String path = null;

		Integer userNo = (Integer) session.getAttribute("userNo");
		
		if (request.getSession().getAttribute("userNo") == null) {
			result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
			result.setRedirect(true);
			return result;
		}

		MyPageJoinDTO summaryInfo = mypageDAO.summaryInfo(userNo);
		
		System.out.println("test");
		MyPageJoinDTO finVolunInfo = mypageDAO.miniFinVol(userNo);
		List<MyPageJoinDTO> pointInfo = mypageDAO.miniPoint(userNo);
		MyPageJoinDTO comVolunInfo = mypageDAO.miniComVol(userNo);
		request.setAttribute("userNo", userNo);
		request.setAttribute("totalVolunTime", summaryInfo.getTotalVolunTime());
		request.setAttribute("rankPoint", summaryInfo.getRankPoint());
		request.setAttribute("totalAmount", summaryInfo.getTotalAmount());
		request.setAttribute("volunActNo", summaryInfo.getVolunActNo());
		request.setAttribute("kkomiLev", summaryInfo.getKkomiLev());
		request.setAttribute("miniPoint", pointInfo);
		
		if (comVolunInfo != null) {
		    System.out.println("예정 봉사 " + comVolunInfo.getVolunActTitle());
		    
		    request.setAttribute("comVolunActTitle", comVolunInfo.getVolunActTitle());
		    request.setAttribute("comVolunActProcEnd", comVolunInfo.getComVolunActProcEnd());
		    request.setAttribute("comVolunActProcBegin", comVolunInfo.getComVolunActProcBegin());
		} else {
		    System.out.println("예정 봉사 없음");

		    request.setAttribute("comVolunActTitle", null);
		    request.setAttribute("comVolunActProcEnd", null);
		    request.setAttribute("comVolunActProcBegin", null);
		}
		
		
		if (finVolunInfo != null) {
		    System.out.println("완료 봉사 " + finVolunInfo.getVolunActTitle());
		    System.out.println("완료 봉사 기간 : " + finVolunInfo.getFinVolunActProcEnd());
		    
		    request.setAttribute("finVolunActTitle", finVolunInfo.getVolunActTitle());
		    request.setAttribute("finVolunActProcEnd", finVolunInfo.getFinVolunActProcEnd());
		    request.setAttribute("finVolunActProcBegin", finVolunInfo.getFinVolunActProcBegin());
		} else {
		    System.out.println("완료 봉사 없음");

		    request.setAttribute("finVolunActTitle", null);
		    request.setAttribute("finVolunActProcEnd", null);
		    request.setAttribute("finVolunActProcBegin", null);
		}
		
		
		
		System.out.println("조건문 통과");
		
		result.setPath("/app/mypage/profile/profile.jsp");
		result.setRedirect(false);
		
		
		
		System.out.println("쿼리문 실행 성공");
		System.out.println(summaryInfo);
		System.out.println(summaryInfo.getTotalVolunTime());
		
		
		
		
		return result;
		
		
	}
}
