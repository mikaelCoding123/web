package com.mikael.web.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


/**
 * @author
 * @version 1.0
 * @date 2025/4/11
 */

@Configuration
public class CaffeeConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("aa");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .maximumSize(1000).expireAfterAccess(Duration.ofSeconds(15))
                .expireAfterWrite(Duration.ofSeconds(20)));
        return cacheManager;
    }

}
