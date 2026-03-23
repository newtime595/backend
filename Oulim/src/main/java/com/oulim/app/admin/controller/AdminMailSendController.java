package com.oulim.app.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.common.util.MailUtil;
import com.oulim.app.user.dto.UserDTO;

public class AdminMailSendController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Result result = new Result();
		AdminDAO adminDAO = new AdminDAO();
		String strOrganNo = request.getParameter("organNo");
		int organNo = Integer.valueOf(strOrganNo);		
		UserDTO organUser = adminDAO.findOrganUserList(organNo);
		
		result.setPath("/admin/dashboard.adm");
		result.setRedirect(true);
		
		if(organUser == null ||organUser.getUserEmail() == null ) {
			System.out.println("이메일 없음");
			out.print("fail");		
			return result;
		}
		try {
	        System.out.println("메일 발송 시작");
	        MailUtil.sendMail(organUser.getUserEmail(), "처리되지 않은 봉사활동이 있습니다.", "봉사활동을 확인해주세요.");
	        System.out.println("메일 발송 성공");
	        out.print("success");
	    } catch (Exception e) {
	        System.out.println("메일 발송 실패");
	        e.printStackTrace();
	        out.print("fail");
	    }
		
		return result;
	}

}
