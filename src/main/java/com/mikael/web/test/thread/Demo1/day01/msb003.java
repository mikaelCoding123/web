package com.mikael.web.test.thread.Demo1.day01;

/**
 * 说明
 *
 * @author Administrator
 */
public class msb003 {

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "m1 start........");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m1 end....");
    }

    public void m2() {
        System.out.println(Thread.currentThread().getName() + "m2 start........");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "m2 end....");
    }

    public static void main(String[] args) {
        msb003 t = new msb003();
    /*
    	new Thread(()->t.m1(),"t1").start(); //()->java8中的lmab下面的为java1.7以下版本
    	new Thread(()->t.m2(),"t1").start();
    */
        new Thread(
                new Runnable() {
                    public void run() {
                        t.m1();
                    }
                })
                .start();

        new Thread(
                new Runnable() {
                    public void run() {
                        t.m2();
                    }
                })
                .start();
    }
}
