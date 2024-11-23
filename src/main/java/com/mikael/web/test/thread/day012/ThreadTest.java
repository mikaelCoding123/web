package com.mikael.web.test.thread.day012;


import java.util.concurrent.TimeUnit;

/**
 * 循环体在线程内部与外部的区别
 */
public class ThreadTest {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(
                    () -> {
                        Add add = new Add();
                        int a = add.anInt(1);

                        System.out.println(a);
                    })
                    .start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+++++++++++++++++++++++++++++");

        new Thread(
                () -> {
                    for (int i = 0; i < 10; i++) {

                        System.out.println(i);

                        //
                    }
                })
                .start();
    }
}
