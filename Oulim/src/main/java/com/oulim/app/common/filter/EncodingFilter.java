package com.oulim.app.common.filter;

import java.io.IOException;

import javax.servlet.*;

public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
    	
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        response.setContentType("text/h; charset=UTF-8");


        chain.doFilter(request, response);
    }
}