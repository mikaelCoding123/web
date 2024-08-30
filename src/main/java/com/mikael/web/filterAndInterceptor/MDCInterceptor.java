package com.mikael.web.filterAndInterceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class MDCInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle.......................");

        if (request.getHeader("head") != null) {

//            request.setAttribute("head", MDCUtils.getHead(request.getHeader("head")));
        }

        return true;
    }

}