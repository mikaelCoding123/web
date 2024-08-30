package com.mikael.web.filterAndInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

@Configuration
public class RegInterceptor implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry)  {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        registry.addInterceptor(new MDCInterceptor()).addPathPatterns("/**");
        interceptor.setCacheSeconds(0);
    }
}
