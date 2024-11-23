package com.mikael.web.test.thread.Demo1.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class My {
    List list = new ArrayList();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        My my = new My();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(
                new Runnable() {
                    public void run() {
                        System.out.println("t1 start!!!");
                        for (int i = 0; i < 5; i++) {
                            my.add(new Object());
                            System.out.println(my.size());
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                        if (my.size() == 5) {
                            latch.countDown();
                            System.out.println("t1 end!!!");
                        }
                    }
                },
                "t1")
                .start();

        new Thread(
                new Runnable() {
                    public void run() {
                        System.out.println("t2  start!!!");
                        if (my.size() == 5) {
                            try {
                                latch.await();
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            System.out.println("t2 end!!!");
                        }
                    }
                },
                "t2")
                .start();
    }
}
