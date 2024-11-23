package com.mikael.web.test.Jdk8Features.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class _001_ComplatableFuture_thenApply {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Object> future = CompletableFuture.supplyAsync(new Supplier<Object>() {
            @Override
            public Object get() {
                System.out.println("supplyAsync....");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "null=====";
            }
        }).thenApply(new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                System.out.println("thenApply....." + o);
                return "null-----";
            }
        });

        Object o = future.get();
        System.out.println(o);
        System.out.println("8888");
    }
}
