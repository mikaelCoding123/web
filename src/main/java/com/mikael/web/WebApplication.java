package com.mikael.web;

import com.mikael.web.utils.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * jdk22
 */
@Slf4j
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {

        // 获取运行时环境对象
        Runtime runtime = Runtime.getRuntime();
        // 获取并打印默认的最大堆内存大小（以字节为单位），然后转换为以兆字节（MB）为单位
        long maxMemory = runtime.maxMemory();
        System.out.println("默认最大堆内存: " + maxMemory / (1024 * 1024) + "MB");
        // 获取并打印默认的初始堆内存大小（以字节为单位），然后转换为以兆字节（MB）为单位
        long totalMemory = runtime.totalMemory();
        System.out.println("默认初始堆内存: " + totalMemory / (1024 * 1024) + "MB");
        System.out.println(SpringVersion.getVersion());

        ResponseEntity<Result> resultResponseEntity = new ResponseEntity<>(HttpStatus.OK);
        SpringApplication.run(WebApplication.class, args);

    }

}
