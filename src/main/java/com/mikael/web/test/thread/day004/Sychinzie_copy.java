package com.mikael.web.test.thread.day004;

import java.util.stream.Stream;

/**
 * 多个生产者多个消费者共同使用同一把锁（LOCK）造成死锁 由于采用if/else来判断
 */
public class Sychinzie_copy {

    private final Object LOCK = new Object();
    private volatile boolean isProduce = false;
    private int i = 0;

    public void produce() {

        synchronized (LOCK) {
            if (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                i = i + 1;
                System.out.println("生产者->>" + i);
                isProduce = true;
                LOCK.notify();
            }
        }
    }

    public void comsume() {
        synchronized (LOCK) {
            if (isProduce) {
                System.out.println("消费者->>" + i);
                isProduce = false;
                LOCK.notify();
            } else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Sychronizetest_copy {

    public static void main(String[] args) {
        Sychinzie sychinzie = new Sychinzie();
        new Thread() {
            @Override
            public void run() {
                while (true) sychinzie.produce();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) sychinzie.comsume();
            }
        }.start();

        Stream.of("p1", "p2")
                .forEach(
                        n -> {
                            new Thread() {
                                @Override
                                public void run() {
                                    while (true) sychinzie.produce();
                                }
                            }.start();
                        });

        Stream.of("c1", "c2")
                .forEach(
                        n -> {
                            new Thread() {
                                @Override
                                public void run() {
                                    while (true) sychinzie.comsume();
                                }
                            }.start();
                        });
    }
}
