package com.mikael.web.test.thread.Demo1.day02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 */
public class msb003 {
    public void t1() {
        System.out.println("t1 ");
    }

    public void t2() {
        System.out.println("t2 ");
    }

    public static void main(String[] args) {
        msb003 m = new msb003();

        Lock lock = new ReentrantLock();
        Thread m1 =
                new Thread(
                        () -> {
                            lock.lock();
                            System.out.println("m1 start!!!!");
                            try {
                                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                            } catch (InterruptedException e) {
                                System.out.println("interrupted!!!");
                                e.printStackTrace();
                            } finally {
                                lock.unlock();
                            }
                            System.out.println("m1 end!!!!");
                        });

        m1.start();

        Thread m2 =
                new Thread(
                        () -> {
                            try {
                                System.out.println("m2 start !!!!");
                                /*	lock.lock();*/
                                // 该段代码不注释时 lock无法获取锁只能一直在等待m1中锁的释放
                                lock.lockInterruptibly(); // 可以对Interrupted做出响应

                                TimeUnit.SECONDS.sleep(3);
                            } catch (InterruptedException e) {

                            } finally {
                                /*lock.unlock();*/
                                // 由与inerruptibly()没有锁的获得故发生异常错误
                            }
                            System.out.println("m2 end！！！");
                        });
        m2.start();

        m2.interrupt(); // 打断m2线程
    }
}
