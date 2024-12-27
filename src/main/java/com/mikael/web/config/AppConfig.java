package com.mikael.web.config;

import jakarta.websocket.server.ServerEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class AppConfig {
    //因为Test01Action里面缺少bean所以提前注入
    @Bean
    public RestTemplate init() {
       return new RestTemplate();
    }

    @Bean
    public ServerEndpointExporter test01ServiceImp() {
        return new ServerEndpointExporter();
    }
}
