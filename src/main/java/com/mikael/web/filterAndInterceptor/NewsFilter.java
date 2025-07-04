package com.mikael.web.filterAndInterceptor;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * @author
 * @version 1.0
 * @date 2025/6/1
 */

//在启动类添加注解 @ServletComponentScan ,asyncSupported表示支持异步
@WebFilter(value = "/test02/*",filterName = "NewsFilter",asyncSupported = true)
@Slf4j
public class NewsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("============NewsFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
