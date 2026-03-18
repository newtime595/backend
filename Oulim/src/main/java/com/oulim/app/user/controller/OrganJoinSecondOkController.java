package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.user.dao.UserDAO;
import com.oulim.app.user.dto.OrganDTO;
import com.oulim.app.user.dto.UserDTO;

public class OrganJoinSecondOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserDTO userDTO = new UserDTO();
		OrganDTO organDTO = new OrganDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();

		String organCertNum = request.getParameter("organCertNum");

		organDTO.setOrganCertNum(request.getParameter("organCertNum"));
		organDTO.setOrganName(request.getParameter("organName"));

		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setUserBirth(request.getParameter("userBirth"));
		userDTO.setUserEmail(request.getParameter("userEmail"));
		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserPw(request.getParameter("userPw"));
		userDTO.setOrganName(request.getParameter("organName"));
		userDTO.setUserPhoneNum(request.getParameter("userPhoneNum"));

		OrganDTO foundOrgan = userDAO.selectOrganByCertNum(organCertNum);

		if (foundOrgan == null) {
			userDAO.insertorgan(organDTO);
			userDTO.setOrganNo(organDTO.getOrganNo());
			userDTO.setOrganName(organDTO.getOrganName());
		} else {
			userDTO.setOrganNo(foundOrgan.getOrganNo());
			userDTO.setOrganName(foundOrgan.getOrganName());
		}

		System.out.println(userDTO);
		System.out.println(organDTO);

		userDAO.organjoin(userDTO);

		result.setPath("/app/user/signin/signup-complete.jsp");
		result.setRedirect(false);

		return result;
	}
}