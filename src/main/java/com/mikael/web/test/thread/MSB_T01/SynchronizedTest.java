package com.mikael.web.test.thread.MSB_T01;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        Msb_t01 msb_t01 = new Msb_t01();
        msb_t01.m();
        msb_t01.n();

        System.out.println("--------------------");
        // synchronized 为可重入锁(即子类上了锁的方法，也可以访问父类上了锁的方法)
        Msb_t01_son msb_t01_son = new Msb_t01_son();
        msb_t01_son.m();
        Thread thread = new Thread();
    }
}

class Msb_t01 {
    public synchronized void m() {
        System.out.println("进入synchronize中的m方法\t start");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("进入Interrupted");
        }
        System.out.println("进入synchronize中的m方法\t end");
    }

    public synchronized void n() {
        System.out.println("进入synchronize中的n方法\tstart");

    /*try {
        TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }*/
        System.out.println("进入synchronize中的n方法\t end");
    }
}

class Msb_t01_son extends Msb_t01 {

    public synchronized void m() {
        System.out.println("child  m start");
        super.m();
        System.out.println("child  m end");
    }
}
