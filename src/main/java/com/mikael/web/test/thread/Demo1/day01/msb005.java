package com.mikael.web.test.thread.Demo1.day01;

public class msb005 {
    synchronized void t() {
        System.out.println("t start!!!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    synchronized void t2() {
        t();
        System.out.println("t2 start!!!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        msb005 a = new msb005();
        new Thread(() -> a.t2(), "t1").start();

        new Thread(() -> a.t2(), "t2").start();
    }
}
