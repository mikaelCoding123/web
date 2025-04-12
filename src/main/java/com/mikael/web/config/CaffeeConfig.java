package com.mikael.web.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
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

    @Bean("caffeeman")
    public Cache<Object, Object> caffeeConfig() {
        return Caffeine.newBuilder().expireAfterAccess(Duration.ofSeconds(60l)).softValues().initialCapacity(100).maximumSize(10000l).build();

    }

}
