package com.mikael.web.test.Jdk8Features.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

/**
 * 跟handle类似
 */
public class _001_ComplatableFuture_whenComplete {
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                int i=1/0;
            }
        });

        CompletableFuture<Void> completableFuture = future.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void unused, Throwable throwable) {
                if(throwable != null){
                    System.out.println(throwable.toString());
                }
                System.out.println();
            }
        });
        CompletableFuture<Void> future1 = future.whenCompleteAsync(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void unused, Throwable throwable) {
                System.out.println("whenCompleteAsync=====");
            }
        });

    }
}
