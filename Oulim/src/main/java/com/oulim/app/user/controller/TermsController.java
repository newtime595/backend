package com.oulim.app.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oulim.app.common.controller.Execute;
import com.oulim.app.common.controller.Result;

public class TermsController implements Execute {
    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Result result = new Result();

        String userType = request.getParameter("userType");

        if("2".equals(userType)) {
            result.setPath("/app/user/signin/signup-terms.jsp");
            request.setAttribute("userType", 2);
        } else {
            result.setPath("/app/user/signin/signup-terms.jsp");
            request.setAttribute("userType", 1);
        }

        return result;
    }
}