package com.oulim.app.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.admin.dto.AdminMemDetailDTO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;
import com.oulim.app.user.dto.LogPointDTO;

public class AdminMemEditController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Result result = new Result();
        AdminMemDAO adminMemDAO = new AdminMemDAO();

        String userNo = request.getParameter("userNo");

        if (userNo != null && !userNo.isEmpty()) {

            int userNoInt = Integer.parseInt(userNo);

            // 회원 정보 조회
            AdminMemDetailDTO member = adminMemDAO.selectDetail(userNoInt);

            // 포인트 내역 조회
            List<LogPointDTO> pointList = adminMemDAO.selectPointList(userNoInt);

            // JSP로 전달
            request.setAttribute("member", member);
            request.setAttribute("pointList", pointList);
        }

        result.setPath("/app/admin/jsp/member-manage/mem-edit.jsp");
        result.setRedirect(false);

        return result;
    }
}