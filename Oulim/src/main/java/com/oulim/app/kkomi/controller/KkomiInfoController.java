package com.oulim.app.kkomi.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.kkomi.dao.KkomiDAO;
import com.oulim.app.kkomi.dto.KkomiJoinDTO;

public class KkomiInfoController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		KkomiDAO kkomiDAO = new KkomiDAO(true);
		KkomiJoinDTO kkomiJoinDTO = new KkomiJoinDTO();	
		Result result = new Result();
		int userNo = (Integer)request.getSession().getAttribute("userNo");
		
		result.setPath("");
		
		return null;
	}

}
