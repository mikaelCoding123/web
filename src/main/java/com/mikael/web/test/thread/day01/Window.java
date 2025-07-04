package com.mikael.web.test.thread.day01;


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Window {
    public static void main(String[] args) {
    /*      new Thread();

    TinkerWindow  tinkerWindow01 =    new  TinkerWindow("一号");
    TinkerWindow  tinkerWindow02  =    new  TinkerWindow("二号");
    TinkerWindow  tinkerWindow03 =    new  TinkerWindow("三号");
    tinkerWindow01.start();
    tinkerWindow02.start();
    tinkerWindow03.start();*/

        final TinkerWindowRunnable tinkerWindowRunnable = new TinkerWindowRunnable();
        Thread thread1 = new Thread(tinkerWindowRunnable, "one");
        Thread thread2 = new Thread(tinkerWindowRunnable, "two");
        Thread thread3 = new Thread(tinkerWindowRunnable, "three");
        thread1.start();
        thread2.start();
        thread3.start();

        new Thread(
                () -> {
                    try {
                        System.out.println("name=======" + Thread.currentThread().getName());
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                "thread-one")
                .start();

        List list = Arrays.asList(IntStream.range(1, 10));
        System.out.println();
    }
}
