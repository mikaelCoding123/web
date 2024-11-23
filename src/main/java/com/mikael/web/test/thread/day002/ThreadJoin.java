package com.mikael.web.test.thread.day002;

import java.util.stream.IntStream;

/**
 * join 必须在start之后 表示将线程与其他线程一起结束 one two three 三个线程都与main线程一起结束.1,2,3三个线程没有互相的关系
 */
public class ThreadJoin {

    public static void main(String[] args) {

        Thread thread1 =
                new Thread(
                        () -> {
                            IntStream.range(1, 10)
                                    .forEach(
                                            n -> System.out.println(Thread.currentThread().getName() + "\tone\t" + n));
                            try {
                                Thread.sleep(1_000);
                                System.out.println(Thread.currentThread().getName() + "结束!!!!!!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });

        Thread thread2 =
                new Thread(
                        () -> {
                            IntStream.range(1, 10)
                                    .forEach(
                                            n -> System.out.println(Thread.currentThread().getName() + "\ttwo\t" + n));
                            try {
                                Thread.sleep(1_000);
                                System.out.println(Thread.currentThread().getName() + "结束!!!!!!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });

        Thread thread3 =
                new Thread(
                        () -> {
                            IntStream.range(1, 10)
                                    .forEach(
                                            n -> System.out.println(Thread.currentThread().getName() + "\tthree\t" + n));
                            try {
                                Thread.sleep(1_000);
                                System.out.println(Thread.currentThread().getName() + "结束!!!!!!");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1到100的数
//    IntStream.range(1, 100).forEach(n -> System.out.println(n));
        System.out.println("main 结束!!!!!");
    }
}
