package com.mikael.web.test.thread.MSB_T01;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 方法中出现异常则释放锁
 */
public class TwoThreadSynchronizedxception {

    public static void main(String[] args) {

        TwoThreadSynchronizedxceptionTest twoThreadSynchronizedxceptionTest =
                new TwoThreadSynchronizedxceptionTest();

        Runnable runnable =
                new Runnable() {
                    @Override
                    public void run() {
                        twoThreadSynchronizedxceptionTest.m();
                    }
                };
        new Thread(runnable, "t1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(runnable, "t2").start();
    }
}

class TwoThreadSynchronizedxceptionTest {

    int count = 0;

    synchronized void m() {

        System.out.println(Thread.currentThread().getName() + "进入 m \t start");
        while (true) {
            System.out.println(Thread.currentThread().getName() + "\tcount:\t" + (count++));
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 5) {
                int i = 1 / 0;
                System.out.println(i);
            }
            if (count == 10) {
                // 退出程序
                System.exit(0);
            }
        }
    }
}
