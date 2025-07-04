package com.mikael.web.filterAndInterceptor.mdc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private WebLogMdcHandlerInterceptor webLogMdcHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webLogMdcHandlerInterceptor)
                .addPathPatterns("/**"); // 这里可以配置拦截的路径
        //.excludePathPatterns("/login"); // 这里可以配置排除的路径
    }
}