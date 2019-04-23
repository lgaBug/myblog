package com.lga.myblog.utils;

import com.lga.myblog.bean.UserInfo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 *describe: 登录过滤
 * @WebFilter("/back/*")   过滤/back/*的所有请求
 * 
 *@author lga 
 *@date  2019/4/21 0021 10:42
 */ 

@WebFilter("/back/*")
public class FilterLogin implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //获取httpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取uri
        String requestURI = httpServletRequest.getRequestURI();
        //获取session和session中的对象
        HttpSession session = httpServletRequest.getSession();
        Object userinfo = (UserInfo)session.getAttribute("userinfo");

        //如果session中含有 userinfo对象， 或者请求的url是登录首页，也放行
        if (userinfo != null || requestURI.contains("/login")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        httpServletRequest.getRequestDispatcher("/back/login").forward(servletRequest,servletResponse);

    }
}
