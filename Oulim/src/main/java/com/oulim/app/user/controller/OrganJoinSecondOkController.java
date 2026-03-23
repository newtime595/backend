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
import com.oulim.app.user.dao.FileOrganCertDAO;
import com.oulim.app.user.dto.OrganCertDTO;

public class OrganJoinSecondOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("organName2 = " + request.getParameter("organName"));
		System.out.println("organCertNum2 = " + request.getParameter("organCertNum"));
		System.out.println("userName2 = " + request.getParameter("userName"));
		System.out.println("userBirth2 = " + request.getParameter("userBirth"));
		System.out.println("userEmail2 = " + request.getParameter("userEmail"));
		System.out.println("organFileSystemName2 = " + request.getParameter("organFileSystemName"));
		System.out.println("organFileOriginalName2 = " + request.getParameter("organFileOriginalName"));

		UserDTO userDTO = new UserDTO();
		OrganDTO organDTO = new OrganDTO();
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		OrganCertDTO organCertDTO = new OrganCertDTO();
		FileOrganCertDAO fileOrganCertDAO = new FileOrganCertDAO();

		String organCertNum = request.getParameter("organCertNum");
		String organFileSystemName = request.getParameter("organFileSystemName");
		String organFileOriginalName = request.getParameter("organFileOriginalName");

		organDTO.setOrganCertNum(request.getParameter("organCertNum"));
		organDTO.setOrganName(request.getParameter("organName"));

		System.out.println("request organName = " + request.getParameter("organName"));
		System.out.println("dto organName = " + organDTO.getOrganName());
		System.out.println("dto organCertNum = " + organDTO.getOrganCertNum());

		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setUserBirth(request.getParameter("userBirth"));
		userDTO.setUserEmail(request.getParameter("userEmail"));
		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserPw(request.getParameter("userPw"));
		userDTO.setOrganName(request.getParameter("organName"));

		OrganDTO foundOrgan = userDAO.selectOrganByCertNum(organCertNum);

		if (foundOrgan == null) {
			userDAO.insertorgan(organDTO);
			userDTO.setOrganNo(organDTO.getOrganNo());
			userDTO.setOrganName(organDTO.getOrganName());
		} else {
			userDTO.setOrganNo(foundOrgan.getOrganNo());
			userDTO.setOrganName(foundOrgan.getOrganName());
		}

		userDAO.organjoin(userDTO);

		organCertDTO.setUserNo(userDTO.getUserNo());
		organCertDTO.setOrganNo(userDTO.getOrganNo());
		organCertDTO.setOrganFileSystemName(organFileSystemName);
		organCertDTO.setOrganFileOriginalName(organFileOriginalName);

		System.out.println(userDTO);
		System.out.println(organDTO);

		
		fileOrganCertDAO.insert(organCertDTO);
		
		request.getSession().removeAttribute("emailVerified");
		result.setPath("/user/signupComplete.usr?joinType=organ");
		result.setRedirect(true);
		return result;
	}
}