package com.mikael.web.filterAndInterceptor;

import cn.hutool.http.server.HttpServerRequest;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpRequest;


/**
 * https://blog.csdn.net/z69183787/article/details/127808802
 * WebFilter失效
 */

@Order(1)
@WebFilter(urlPatterns = "/test01/*",filterName = "LoginFilter01")
@Slf4j
public class LoginFilter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest)servletRequest;
        log.info("LoginFilter01=====urlPatterns==========/test01/*===="+servletRequest1.getRequestURI());
        //将信息往下传
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
