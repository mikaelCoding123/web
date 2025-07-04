package com.mikael.web.test.Jdk8Features;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;

/**
 * 创建多个线程
 */
public class Stream2 {
    public static void main(String[] args) {
        List<String> objects = Arrays.asList("12341", "sf", "gr", "gv");
        objects.stream().forEach(n -> {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
            }, n).start();
        });

    }
}
