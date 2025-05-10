package com.mikael.web.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;


/**
 * @author
 * @version 1.0
 * @date 2025/4/11
 */
//https://blog.51cto.com/u_15912723/13805509
@Configuration
public class CaffeeConfig {

    @Bean
    public CaffeineCacheManager caffeineManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        //caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterAccess(Duration.ofSeconds(60l)).softValues().initialCapacity(100).maximumSize(10000l).build());
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(Duration.ofSeconds(10l)).initialCapacity(100).maximumSize(200));

        return caffeineCacheManager;
    }

}
