package com.mikael.web.test.thread.day011;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 独占锁`非公平锁` 1.普通同步方法（实例方法），锁是当前实例对象(this) ，进入同步代码前要获得当前实例的锁 2.静态同步方法，锁是当前类的class对象
 * ，进入同步代码前要获得当前类对象的锁 3.同步方法块，锁是括号里面的对象，对给定对象加锁，进入同步代码库前要获得给定对象的锁。
 *
 * <p>JMM关于synchronized的两条规定：
 *
 * <p>　　1）线程解锁前，必须把共享变量的最新值刷新到主内存中
 *
 * <p>　　2）线程加锁时，将清空工作内存中共享变量的值，从而使用共享变量时需要从主内存中重新获取最新的值
 */
class Phone {

    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "\t sendMsg");
        sendEmail();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "#########\t sendEmail");
    }
}

public class ReentrantLocks {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(
                () -> {
                    phone.sendMsg();
                },
                "t1")
                .start();
        // t2 与t1不能同时进行，必须等t1结束才能继续执行
        new Thread(
                () -> {
                    phone.sendMsg();
                },
                "t2")
                .start();
    }
}
