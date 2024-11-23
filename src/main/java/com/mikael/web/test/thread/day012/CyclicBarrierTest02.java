package com.mikael.web.test.thread.day012;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest02 {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new A());

    public static void main(String[] args) {


        new Thread(() -> {
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(2222);
        }).start();

        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(3333);

    }
}

class A implements Runnable {

    @Override
    public void run() {
        System.out.println(1);
    }
}
