package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.user.dao.UserDAO;
import com.oulim.app.user.dto.UserDTO;

public class NormalJoinSecondOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDTO userDTO = new UserDTO();
        UserDAO userDAO = new UserDAO();
        Result result = new Result();
        
        
        userDTO.setUserName(request.getParameter("userName"));
        userDTO.setUserBirth(request.getParameter("userBirth"));
        userDTO.setUserEmail(request.getParameter("userEmail"));
        userDTO.setUserPhoneNum(request.getParameter("userPhoneNum"));
        userDTO.setUserId(request.getParameter("userId"));
        userDTO.setUserPw(request.getParameter("userPw"));
        userDTO.setUserNickname(request.getParameter("userNickname"));

        System.out.println(userDTO);

        userDAO.normaljoin(userDTO);

        result.setPath("/app/user/signin/signup-complete.jsp");
        result.setRedirect(false);

        return result;
	}

}
