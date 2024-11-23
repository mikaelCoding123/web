package com.mikael.web.test.thread;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest01 extends Thread {
    @Override
    public void run() {
        System.out.println("进入了Test 01 ");
    }
}

class Main {

    public static void main(String[] args) {

        ThreadTest01 threadTest01 = new ThreadTest01();
        ReentrantLock reentrantLock = new ReentrantLock();
        AbstractQueuedSynchronizer abstractQueuedSynchronizer;


    }
}
