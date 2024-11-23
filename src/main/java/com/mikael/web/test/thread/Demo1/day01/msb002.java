package com.mikael.web.test.thread.Demo1.day01;

public class msb002 implements Runnable {
    private int count = 10;

    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void main(String[] args) {
        msb002 m = new msb002();
        for (int i = 0; i < 5; i++) {
            new Thread(m, "thread" + i).start(); // 5个线程执行count变量的数据
        }
    }
}
