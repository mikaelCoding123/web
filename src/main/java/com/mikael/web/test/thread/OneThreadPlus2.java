package com.mikael.web.test.thread;

import java.util.concurrent.TimeUnit;

public class OneThreadPlus2 {
    public static void main(String[] args) {

        Object o = new Object();
        M1 m = new M1();
        int j = 0;
        for (int i = 0; i < 3; i++) {
            new Thread(
                    () -> {
                        while (true) {

                            m.add();
                        }
                    },
                    "++" + i)
                    .start();
            new Thread(
                    () -> {
                        while (true) {
                            m.dec();
                        }
                    },
                    "--" + i)
                    .start();
        }

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}

class M1 {
    private static int i = 0;

    public synchronized void add() {
        i = i++;
        System.out.println(Thread.currentThread().getName() + "\t" + i);
    }

    public synchronized void dec() {
        i = i--;
        System.out.println(Thread.currentThread().getName() + "\t" + i);
    }
}
