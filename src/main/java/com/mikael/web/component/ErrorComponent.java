package com.mikael.web.component;

import cn.hutool.core.util.IdUtil;
import org.slf4j.MDC;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Locale;


//直接用tomcat或者nginx直接配置错误页面
@Component
public class ErrorComponent implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage error400Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/UNAUTHORIZED.html");
        ErrorPage error401Page = new ErrorPage(HttpStatus.BAD_REQUEST, "/error401Page.html");
        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/err.html");
        registry.addErrorPages(error400Page,error401Page,error404Page,error500Page);
    }


    public static void main(String[] args) {
        System.out.println(IdUtil.fastSimpleUUID().toLowerCase());
    }
}
