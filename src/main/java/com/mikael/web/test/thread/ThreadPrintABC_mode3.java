package com.mikael.web.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 采用线程池的方式让3个线程分别依次按顺序按执行，线程需为runnable
 */
public class ThreadPrintABC_mode3 {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    static Thread t1 =
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("This is thread1");
                        }
                    });
    static Thread t2 =
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("This is thread2");
                        }
                    });
    static Thread t3 =
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("This is thread3");
                        }
                    });

    public static void main(String[] args) throws InterruptedException {
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.shutdown();
    }
}
