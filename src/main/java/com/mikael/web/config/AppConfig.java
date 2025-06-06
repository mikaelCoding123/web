package com.mikael.web.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.mikael.web.filterAndInterceptor.LoginFilter;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class AppConfig {

    @Bean
    public RestTemplate init() {
        return new RestTemplate();
    }

    @Bean
    public ServerEndpointExporter test01ServiceImp() {
        return new ServerEndpointExporter();
    }


    // 二级缓存：Redis
//    @Bean
//    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new GenericJackson2JsonRedisSerializer()))
//                .entryTtl(Duration.ofSeconds(100));  // 分布式缓存过期时间:ml-citation{ref="4,7" data="citationList"}
//        return RedisCacheManager.builder(factory).cacheDefaults(config).build();
//    }


    @Bean
    public CaffeineCacheManager caffeineCacheManager() {
        CaffeineCacheManager manager = new CaffeineCacheManager();
        manager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .maximumSize(1000));
        return manager;
    }

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory factory) {
        return RedisCacheManager.builder(factory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
                        .entryTtl(Duration.ofHours(1)))
                .build();
    }

    @Primary
    @Bean
    public CompositeCacheManager compositeCacheManager(
            CaffeineCacheManager caffeineManager,
            RedisCacheManager redisManager) {
        List<CacheManager> managers = Arrays.asList(caffeineManager, redisManager);
        CompositeCacheManager compositeManager = new CompositeCacheManager();
        compositeManager.setCacheManagers(managers);
        compositeManager.setFallbackToNoOpCache(true);
        return compositeManager;
    }



    /**
     *
     *  @Bean
     *   public Employee zhangSan() { return new Employee("张三"); }
     *
     *   @Bean
     *   @Primary  // 优先注入此Bean
     *   public Employee liSi() { return new Employee("李四"); }
     *
     *   在复杂场景（如多数据源、策略模式实现）中，可作为默认选择
     *
     */
//    // 组合多级缓存（Caffeine+Redis多级缓存配置）
//    @Primary//解决依赖注入冲突
//    @Bean
//    public CacheManager compositeCacheManager(
//            CaffeineCacheManager caffeineCacheManager,
//            RedisCacheManager redisCacheManager) {
//        List<CacheManager> managers = Arrays.asList(caffeineCacheManager, redisCacheManager);
//        CompositeCacheManager cacheManager = new CompositeCacheManager();
//        cacheManager.setCacheManagers(managers);
//        cacheManager.setFallbackToNoOpCache(false);  // 启用多级回退:ml-citation{ref="1,4" data="citationList"}
//        return cacheManager;
//    }


    //    redisson
    @Bean
    public RedissonClient redisson() {
        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0).setTimeout(30);
        return Redisson.create();
    }


    //拦截器的注册
    @Bean
    public FilterRegistrationBean<LoginFilter> myFilter() {
        FilterRegistrationBean<LoginFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new LoginFilter());
        bean.addUrlPatterns("/*");
        bean.setAsyncSupported(true);//支持异步操作
        bean.setOrder(1);  // 设置执行顺序
        return bean;
    }


}
