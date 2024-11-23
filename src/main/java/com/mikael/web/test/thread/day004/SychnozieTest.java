package com.mikael.web.test.thread.day004;

import java.util.stream.Stream;

/**
 * 多个生产者多个消费者情况:
 */
public class SychnozieTest {

    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;
    private int i = 0;

    public void produce() {


        while (isProduce) {
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i = i + 1;
        System.out.println("p 生产者->>" + Thread.currentThread().getName() + "    " + i);
        LOCK.notifyAll();
        isProduce = true;
    }


    public void comsume() {

        while (!isProduce) {
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c 消费者->>" + Thread.currentThread().getName() + "    " + i);
        LOCK.notifyAll();
        isProduce = false;
    }

}

class Synchronize2test {

    public static void main(String[] args) {
        Sychnozie2 sychinzie = new Sychnozie2();
        Stream.of("p1", "p2")
                .forEach(
                        n -> {
                            new Thread(n) {
                                @Override
                                public void run() {
                                    while (true) {
                                        sychinzie.produce();
                                    }
                                }
                            }.start();
                        });

        Stream.of("c1", "c2")
                .forEach(
                        n -> {
                            new Thread(n) {
                                @Override
                                public void run() {
                                    while (true) {
                                        sychinzie.comsume();
                                    }
                                }
                            }.start();
                        });
    }
}