package com.mikael.web.test.thread.Demo1.day02;

import java.util.concurrent.TimeUnit;

/**
 * 重复练习volatile中的内容
 *
 * @author Administrator
 */
public class msb001 {

    volatile boolean flag = true;

    synchronized void m1() {
        System.out.println("m1 start！！");

        while (flag) {
        }
        System.out.println("m1 end！！");
    }

    public static void main(String[] args) {
        msb001 t = new msb001();

        new Thread(
                new Runnable() {
                    public void run() {
                        t.m1();
                    }
                })
                .start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        t.flag = false;
    }
}
