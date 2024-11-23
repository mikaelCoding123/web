package com.mikael.web.test.thread;

/**
 * 3个线程分别依次按顺序按执行（1的线程执行完再执行2线程，再执行3线程，不能循环执行）
 */
public class ThreadPrintABC_mode2 {

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
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
