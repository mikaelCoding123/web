package com.mikael.web.test.Jdk8Features.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * 未完成
 *
 * @author mikael
 */
public class CompletableFutureTest {
    public static void main(String[] args) {
        //
        CompletableFuture();
    }

    public static void CompletableFuture() {
        CompletableFuture hello = CompletableFuture.completedFuture("hello");
        hello.isDone();
        hello.getNow(null);
    }
}
