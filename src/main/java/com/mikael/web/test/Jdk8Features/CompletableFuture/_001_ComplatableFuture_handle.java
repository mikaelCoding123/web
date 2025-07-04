package com.mikael.web.test.Jdk8Features.CompletableFuture;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 1、在get()中捕获了异常，handle()中就不会执行了
 * 2、apply(Object o, Throwable throwable) 中的o为get()中return的内容,throwable 为异常
 */
public class _001_ComplatableFuture_handle {
    public static void main(String[] args) {

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("123===");
                int i = 1 / 0;
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "get====";
            }
        });
        CompletableFuture<Object> handle = future.handle(new BiFunction<Object, Throwable, Object>() {
            @Override
            public Object apply(Object o, Throwable throwable) {
                System.out.println("handle====" + o);
                if (throwable != null) {
                    System.out.println(throwable);
                }

                return null;
            }
        });
        try {
            handle.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
