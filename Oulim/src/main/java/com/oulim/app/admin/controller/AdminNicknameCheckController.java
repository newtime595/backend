package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminNicknameCheckController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	System.out.println("AdminNicknameCheck컨트롤러===");
        AdminMemDAO adminMemDAO = new AdminMemDAO();

        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String userNickname = request.getParameter("userNickname");        
        if(userNickname != null) {
            userNickname = userNickname.trim();
        }

        String currentNickname = adminMemDAO.selectNicknameByUserNo(userNo);

        System.out.println("기존닉네임 : " + currentNickname);
        System.out.println("입력닉네임 : " + userNickname);

        if(currentNickname != null && currentNickname.equals(userNickname)) {
        	response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().write("same");
            return null;
        }

        int count = adminMemDAO.checkNicknameForUpdate(userNo, userNickname);

        if(count > 0) {
            response.getWriter().write("duplicated");
        } else {
            response.getWriter().write("available");
        }

        return null;
    }
}