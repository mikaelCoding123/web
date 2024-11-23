package com.mikael.web.test.thread.Demo1.day02;

import java.util.concurrent.locks.ReentrantLock;

public class msb004 extends Thread {
    static final ReentrantLock lock = new ReentrantLock(true); // / 公平锁

    public void m() {

        lock.lock();
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "  获得的锁");
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        msb004 t = new msb004();
        new Thread(
                () -> {
                    t.m();
                },
                "t1")
                .start();

        new Thread(
                () -> {
                    t.m();
                },
                "t2")
                .start();
    }
}
