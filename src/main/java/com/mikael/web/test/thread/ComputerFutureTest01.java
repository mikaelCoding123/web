package com.mikael.web.test.thread;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ComputerFutureTest01 {
    private static final ExecutorService POOL = Executors.newFixedThreadPool(4, new CustomizableThreadFactory("SbxxService-pool-"));
    private static final List<Future<String>> futurelist = new ArrayList<Future<String>>();

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            POOL.execute(new Runnable() {
                @Override
                public void run() {
                    sleep(2, TimeUnit.SECONDS);
                }
            });


            POOL.execute(new Runnable() {
                @Override
                public void run() {
                    sleep(3, TimeUnit.SECONDS);
                }
            });
        }
        try {
            POOL.shutdown();
            if (POOL.awaitTermination(1, TimeUnit.DAYS)) {
                System.out.println("====================");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void sleep(int i, TimeUnit seconds) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class T01 implements Runnable {

    @Override
    public void run() {
        System.out.println("=======t01========");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class T02 implements Runnable {

    @Override
    public void run() {
        System.out.println("======t02=========");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}