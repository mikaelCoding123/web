package com.mikael.web.filterAndInterceptor;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Order(2)
@WebFilter(urlPatterns = "/test02/*",filterName = "LoginFilter02")
@Slf4j
public class LoginFilter02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servletRequest1 = (HttpServletRequest)servletRequest;
        log.info("LoginFilter02=====urlPatterns==========/test02/*===="+servletRequest1.getRequestURI());
        //将信息往下传
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
