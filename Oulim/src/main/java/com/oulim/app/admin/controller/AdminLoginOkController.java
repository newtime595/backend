package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.admin.dto.AdminDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminLoginOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stuob
		System.out.println("adminloginOk컨트롤러=====");
		
	    AdminDTO adminDTO = new AdminDTO();
	    AdminDAO adminDAO = new AdminDAO();
	    Result result = new Result();
	    //값을 받고
	    String adminId = request.getParameter("adminId");
	    String adminPw = request.getParameter("adminPw");
	    System.out.println("adminloginOk컨트롤러==" + adminId);
	    System.out.println("adminloginOk컨트롤러==" + adminPw);
	    		
	    HttpSession session = request.getSession(); // 세션이 안전하대요
	    //dto에 담아서
	    adminDTO.setAdminId(adminId);
	    adminDTO.setAdminPw(adminPw);
	    //dao 호출
	    int adminNo = adminDAO.login(adminDTO);
	    System.out.println(adminNo);
	    
	    String path;
	    

	    //세션값 불러오기
	    if(adminNo != 0) {
	          path = "/admin/dashboard.adm"; //로그인 성공시 경로
		      session.setAttribute("adminNo", adminNo);
	          System.out.println("세션값 : " + adminNo);
//		      path = "/app/admin/jsp/dashboard/dashboard.jsp"; // 로그인 성공 시 대시보드

	      }else {
	        // 로그인 실패
	    	  request.setAttribute("loginError", "아이디 또는 비밀번호가 올바르지 않습니다.");
	    	  
	    	  result.setPath("/app/admin/jsp/login.jsp");
	    	  result.setRedirect(false);
	    	  return result;
	    	  
	    }
	    // 안에 바로 설정해도 된다.
	    result.setPath(path);
	    result.setRedirect(true);

	    return result;
	}

}
