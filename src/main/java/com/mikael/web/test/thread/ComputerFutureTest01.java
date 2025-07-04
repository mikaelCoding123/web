package com.mikael.web.test.thread;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ComputerFutureTest01 {
    private static final ExecutorService POOL = Executors.newFixedThreadPool(4, new CustomizableThreadFactory("SbxxService-pool-"));
    private static final List<Future<String>> futurelist = new ArrayList<Future<String>>();

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            POOL.execute(new Runnable() {
                @Override
                public void run() {
                    sleep(2);
                }
            });


            POOL.execute(new Runnable() {
                @Override
                public void run() {
                    sleep(3);
                }
            });
        }
        POOL.shutdown();
//            if (POOL.awaitTermination(1L, TimeUnit.SECONDS)) {
//                System.out.println("====================");
//            }

    }

    private static void sleep(int i) {
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