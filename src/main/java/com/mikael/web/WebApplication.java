package com.mikael.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//import java.io.Serial;
import java.io.Serializable;

/**
 * jdk17
 */
@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
@ServletComponentScan
public class WebApplication implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(WebApplication.class);


    public static void main(String[] args) {


        MDC.put("traceId", "1234567890");

        // 获取运行时环境对象
        Runtime runtime = Runtime.getRuntime();
        // 获取并打印默认的最大堆内存大小（以字节为单位），然后转换为以兆字节（MB）为单位
        long maxMemory = runtime.maxMemory();
        System.out.println("默认最大堆内存: " + maxMemory / (1024 * 1024) + "MB");
        // 获取并打印默认的初始堆内存大小（以字节为单位），然后转换为以兆字节（MB）为单位
        long totalMemory = runtime.totalMemory();
        System.out.println("默认初始堆内存: " + totalMemory / (1024 * 1024) + "MB");
        System.out.println("Spring Version "+SpringVersion.getVersion());
        System.out.println("jdk version: "+System.getProperty("java.version"));

        ConfigurableApplicationContext run = SpringApplication.run(WebApplication.class, args);



        System.out.println(runtime.freeMemory()/(1024 * 1024) + "MB");

        log.info("启动完成。。。。。");
        System.out.println("启动完成。。。。。。。。。");

        String code = "0471";

        //dev-0989-01
        //本地开发的新项目提交到dev
        //修复dev的bug到fix-03
    }

}
