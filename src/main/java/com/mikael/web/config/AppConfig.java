package com.mikael.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate init() {
       return new RestTemplate();
    }

    @Bean
    public ServerEndpointExporter test01ServiceImp() {
        return new ServerEndpointExporter();
    }
}
