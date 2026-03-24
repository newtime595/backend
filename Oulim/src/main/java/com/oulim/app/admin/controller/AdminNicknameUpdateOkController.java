package com.oulim.app.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.admin.dao.AdminMemDAO;
import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class AdminNicknameUpdateOkController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminMemDAO adminMemDAO = new AdminMemDAO();
        Result result = new Result();

        int userNo = Integer.parseInt(request.getParameter("userNo"));
        String userNickname = request.getParameter("userNickname");

        if(userNickname == null || userNickname.trim().isEmpty()) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/memDetail.adm?userNo=" + userNo + "&error=empty");
            return result;
        }

        userNickname = userNickname.trim();

        String currentNickname = adminMemDAO.selectNicknameByUserNo(userNo);

        // 기존 닉네임과 같으면 저장 금지
        if(currentNickname != null && currentNickname.equals(userNickname)) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/memDetail.adm?userNo=" + userNo + "&error=same");
            return result;
        }

        // 다른 회원이 사용 중인지 검사
        int count = adminMemDAO.checkNicknameForUpdate(userNo, userNickname);
        if(count > 0) {
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/admin/memDetail.adm?userNo=" + userNo + "&error=duplicated");
            return result;
        }

        // 저장
        adminMemDAO.updateNickname(userNo, userNickname);

        result.setRedirect(true);
        result.setPath(request.getContextPath() + "/admin/memDetail.adm?userNo=" + userNo + "&success=nicknameUpdated");

        return result;
    }
}