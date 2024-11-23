package com.mikael.web.test.thread.Demo1.day01;

import java.util.concurrent.TimeUnit;

/*
 *脏读现象：在写入找那个加了synchronized而没有在读时加synchronized
 *
 *
 */
public class msb004 {
    private String name;
    private int balance;

    public synchronized void set(String name, int balance) {
        this.name = name;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public synchronized int getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        msb004 t = new msb004();
        new Thread(() -> t.set("zhangsan", 100)).start();
        System.out.println(t.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(() -> t.getBalance("zhangsan")).start();
        System.out.println(t.getBalance("zhangsan"));
        try {
            TimeUnit.SECONDS.sleep(7);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        new Thread(() -> t.getBalance("zhangsan")).start();
        System.out.println(t.getBalance("zhangsan"));
    }
}
