package com.mikael.web.test.thread.Demo1.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class menshuan {
    /* volatile */ List list = new ArrayList();

    public void add(Object i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        menshuan m = new menshuan();
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(
                () -> {
                    System.out.println("t2启动");
                    if (m.size() != 5) {

                        try {
                            // 等待门闩的打开
                            latch.await();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    System.out.println("t2结束！！");
                },
                "t2")
                .start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new Thread(
                () -> {
                    System.out.println("t1启动！！！");
                    for (int a = 0; a < 5; a++) {
                        m.add(new Object());
                        System.out.println(m.size());
                        if (m.size() == 5) {
                            // 打开门闩，让t2得以执行，将CountDownLatch(1)中的1变成0
                            latch.countDown();
                        }

                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                },
                "t1")
                .start();
    }
}
