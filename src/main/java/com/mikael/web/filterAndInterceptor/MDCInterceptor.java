package com.mikael.web.filterAndInterceptor;


import com.mikael.web.utils.MDCUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class MDCInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        if (request.getHeader("head") != null) {

            request.setAttribute("head", MDCUtils.getTraceId());
        }

        return true;
    }

}