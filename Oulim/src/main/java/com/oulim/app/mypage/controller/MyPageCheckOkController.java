package com.oulim.app.mypage.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.mypage.dao.MyPageJoinDAO;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageCheckOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		MyPageJoinDAO mypageDAO = new MyPageJoinDAO();
		MyPageJoinDTO mypageJoinDTO = new MyPageJoinDTO();
		HttpSession session = request.getSession();
		String path = null;
		
		Integer userNo = (Integer) session.getAttribute("userNo");
		
		String userPw = request.getParameter("userPw");
		
		System.out.println(userNo);
		
	      if(request.getSession().getAttribute("userNo") == null) {
	          result.setPath(request.getContextPath() + "/app/user/login/login.jsp");
	          result.setRedirect(true);
	          return result;
	       }
		
	      Map<String, Object> userMap = new HashMap<>();
	      userMap.put("userNo", userNo);
	      userMap.put("userPw", userPw);
	      
	      
		if(mypageDAO.enterMyPage(userMap)) {
			System.out.println("비밀번호 일치 조건문 진입");
			MyPageJoinDTO summaryInfo = mypageDAO.summaryInfo(userNo);
			
			System.out.println("test");
			MyPageJoinDTO finVolunInfo = mypageDAO.miniFinVol(userNo);
			List<MyPageJoinDTO> pointInfo = mypageDAO.miniPoint(userNo);
			MyPageJoinDTO comVolunInfo = mypageDAO.miniComVol(userNo);
//			System.out.println("예정 봉사 " + comVolunInfo.getVolunActTitle());
//			System.out.println("완료 봉사 " + finVolunInfo.getVolunActTitle());
//			System.out.println("예정 봉사 기간" + comVolunInfo.getComVolunActProcBegin());
//			System.out.println("완료 봉사 기간 : " + finVolunInfo.getFinVolunActProcEnd());
//			System.out.println("포인트 정보 : " + pointInfo);
			
//			System.out.println(pointInfo);
//			System.out.println("fin" + finVolunInfo.toString());
//			System.out.println("com" + comVolunInfo.toString());
//			System.out.println("sum" + summaryInfo.toString());
			request.setAttribute("miniPoint", pointInfo);
			
			request.setAttribute("totalVolunTime", summaryInfo.getTotalVolunTime());
			request.setAttribute("rankPoint", summaryInfo.getRankPoint());
			request.setAttribute("totalAmount", summaryInfo.getTotalAmount());
			request.setAttribute("volunActNo", summaryInfo.getVolunActNo());
			request.setAttribute("kkomiLev", summaryInfo.getKkomiLev());
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
		else {
			System.out.println("실패!");
		}
		
		path = "/app/mypage/check/check.jsp"; // 일단 내 페이지로 > 테스트용
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
		
		
	}

}
