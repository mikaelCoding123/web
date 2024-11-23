package com.mikael.web.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 采用CountDownLatch方式让3个线程分别依次按顺序按执行，线程需为runnable
 */
public class ThreadPrintABC_mode4 {
    static CountDownLatch countDownLatch1 = new CountDownLatch(1);
    static CountDownLatch countDownLatch2 = new CountDownLatch(1);

    static Thread t1 =
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("  thread1");
                            countDownLatch1.countDown();
                        }
                    });
    static Thread t2 =
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                countDownLatch1.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("  thread2");
                            countDownLatch2.countDown();
                        }
                    });
    static Thread t3 =
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                countDownLatch2.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("  thread3");
                        }
                    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        t3.start();

        TimeUnit.SECONDS.sleep(2);
        System.exit(0);
    }
}
