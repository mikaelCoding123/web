package com.mikael.web.test.thread.day01;

public class TinkerWindowRunnable implements Runnable {
    private final int max = 50;
    private int index = 0;

    @Override
    public void run() {
        while (index <= max) {
            System.out.println("name:" + Thread.currentThread().getName() + "号码" + (index++));
        }
    }
}
