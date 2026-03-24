package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.admin.dao.AdminPointDAO;
import com.oulim.app.admin.dto.AdminMemDetailDTO;
import com.oulim.app.admin.dto.AdminPointDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminMemUpdateOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    Result result = new Result();
	    AdminMemDAO adminMemDAO = new AdminMemDAO();

	    int userNo = Integer.parseInt(request.getParameter("userNo"));
	    String userNickname = request.getParameter("userNickname");
	    String userAddress = request.getParameter("userAddress");
	    String userAddressDetail = request.getParameter("userAddressDetail");

	    AdminMemDetailDTO adminMemDetailDTO = new AdminMemDetailDTO();
	    adminMemDetailDTO.setUserNo(userNo);
	    adminMemDetailDTO.setUserNickname(userNickname);
	    adminMemDetailDTO.setUserAddress(userAddress);
	    adminMemDetailDTO.setUserAddressDetail(userAddressDetail);
	    adminMemDAO.update(adminMemDetailDTO);
	    
	    String pointStr = request.getParameter("pointAmount");

	    if(pointStr != null && !pointStr.isEmpty()) {
	        int amount = Integer.parseInt(pointStr);

	        if(amount != 0){
	            AdminPointDAO pointDAO = new AdminPointDAO();

	            AdminPointDTO adminPointDTO = new AdminPointDTO();
	            adminPointDTO.setUserNo(userNo);
	            adminPointDTO.setChangeAmount(Math.abs(amount));

	            if(amount > 0){
	            	adminPointDTO.setLogReason("관리자 포인트 지급");
	                pointDAO.plusPoint(adminPointDTO);
	            } else {
	            	adminPointDTO.setLogReason("관리자 포인트 차감");
	                pointDAO.minusPoint(adminPointDTO);
	            }

	            pointDAO.insertPointLog(adminPointDTO);
	        }
	    }

	    result.setRedirect(true);
	    result.setPath("/admin/memDetail.adm?userNo=" + userNo);

	    return result;
	}

}
