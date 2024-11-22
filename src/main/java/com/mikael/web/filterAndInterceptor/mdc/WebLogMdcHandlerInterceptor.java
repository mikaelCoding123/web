package com.mikael.web.filterAndInterceptor.mdc;

import cn.hutool.core.lang.UUID;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class WebLogMdcHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader("traceId");

        //过滤js、html等页面的请求
        if (".".indexOf(request.getRequestURI()) == 0) {
            log.info(request.getRequestURI() + "==========11");
            return true;
        }
        if (StringUtils.isBlank(traceId)) {
            traceId = UUID.randomUUID().toString(true);
        }
        MDC.put("traceId", traceId);
        traceId = null;
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

        MDC.clear();
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    }


    public static void main(String[] args) {
        String str = "1234";
        System.out.println(str.indexOf("8"));
    }


}
