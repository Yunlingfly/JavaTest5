package com.hand.infra.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 配置过滤器的顺序，从小到大排序
//@Order(2)
//@WebFilter(filterName = "characterfilter", urlPatterns = "/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("No.2 Character filter initialized successfully");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

//        httpRequest.setCharacterEncoding("UTF-8");
//        httpResponse.setCharacterEncoding("UTF-8");
//
//        System.out.println("No.2 Character filter");
//        System.out.println("URL:"+httpRequest.getRequestURL());
        chain.doFilter(httpRequest,httpResponse);

    }

    @Override
    public void destroy() {

    }
}
