package com.mikael.web.test.thread;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

/**
 * @Description: https://www.jianshu.com/p/6bac52527ca4
 * @Author: mikael
 */

public class ComputerFuture {
    public static void main(String[] args) {
        //
        CompletableFuture<String> uCompletableFuture1 =
                CompletableFuture.supplyAsync(
                        () -> {
                            System.out.println("1-1-1");
                            sleep(16);
                            return "1-1-2";
                        });
        CompletableFuture<String> uCompletableFuture2 =
                CompletableFuture.supplyAsync(
                        () -> {
                            System.out.println("2-2-1");
                            sleep(11);
                            return "2-2-2";
                        });

        CompletableFuture<String> completableFuture3 =
                uCompletableFuture2.thenCombine(
                        uCompletableFuture1,
                        new BiFunction<String, String, String>() {
                            @Override
                            public String apply(String s, String s2) {
                                System.out.println("3-1");
                                sleep(7);
                                return "3完成";
                            }
                        });
        sleep(10);
        System.out.println(completableFuture3.join());

        // 按顺序执行
        // 执行结果：
        // 1-1-1
        // 2-2-1
        // 3-1
        // 3完成
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
