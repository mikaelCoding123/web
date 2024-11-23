package com.mikael.web.test.thread.Demo1.day02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock的用法 ReentrantLock()是一把手动锁 该锁需要手动释放一般在fanlly中写unlock
 *
 * @author Administrator
 */
public class msb002 {
    Lock lock = new ReentrantLock();

    public void m1() {
        try {
            lock.lock(); // 相当于synchronized(this)

            for (int i = 0; i < 5; i++) {

                TimeUnit.SECONDS.sleep(3);
                System.out.println("m1 start!!!!");
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock(); // 手动释放锁
        }
    }

    public void m2() {
        lock.lock();
        System.out.println("m2 start！！！！");
        lock.unlock(); // 手动释放锁
    }

    public static void main(String[] args) {
        msb002 t = new msb002();
        new Thread(t::m1).start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new Thread(t::m2).start();
    }
}
