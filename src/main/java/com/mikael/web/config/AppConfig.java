package com.mikael.web.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.time.Duration;

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

//    caffeine
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("aa");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .maximumSize(1000).expireAfterAccess(Duration.ofSeconds(15))
                .expireAfterWrite(Duration.ofSeconds(20)));
        return cacheManager;
    }

//    redisson
    @Bean
    public RedissonClient redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://localhost:6379").setDatabase(1).setTimeout(30);
        return Redisson.create(config);
    }


}
