package com.mikael.web.test.thread.day014;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * a线程完成后,通知b线程,b线程完成后,通知c线程
 */
class conditionsFor {
    private int n = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition();
    private final Condition c3 = lock.newCondition();
    private final Condition c2 = lock.newCondition();

    public void play5() {
        lock.lock();
        try {
            while (n != 1) {
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "---------------" + i);
            }
            n = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void play10() {
        lock.lock();
        try {
            while (n != 2) {
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "+++++++++++++++++++" + i);
            }
            n = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void play15() {
        lock.lock();
        try {
            while (n != 3) {
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "**********************" + i);
            }
            n = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class Locktest {

    public static void main(String[] args) {
        conditionsFor conditionsFor = new conditionsFor();

        new Thread(
                () -> {
                    conditionsFor.play5();
                },
                "a")
                .start();
        new Thread(
                () -> {
                    conditionsFor.play10();
                },
                "b")
                .start();
        new Thread(
                () -> {
                    conditionsFor.play15();
                },
                "c")
                .start();
    }
}
