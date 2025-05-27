package com.mikael.web.config;

import ch.qos.logback.core.util.TimeUtil;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Timer;


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
                .maximumSize(1000)
                .expireAfterWrite(Duration.ofSeconds(10)));
        return cacheManager;
    }

}
