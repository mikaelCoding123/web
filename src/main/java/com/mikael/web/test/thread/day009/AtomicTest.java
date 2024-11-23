package com.mikael.web.test.thread.day009;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private static final int a = 0;

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();

        for (int i = 0; i < 110; i++) {

            new Thread(
                    () -> {
                        atomicInteger.getAndAdd(1);
                    })
                    .start();
        }
        // 线程全部结束后执行,否则输出的值,可能并不是所有线程结束后的值
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atomicInteger.get() + "\t" + a);

        // atomic

    }
}
