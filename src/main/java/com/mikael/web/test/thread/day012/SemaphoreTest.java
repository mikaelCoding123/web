package com.mikael.web.test.thread.day012;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3, true); // 有3个车位 fair 为是否公平锁

        for (int i = 0; i <= 6; i++) { // 有6个车

            new Thread(
                    () -> {
                        try {
                            semaphore.acquire();
                            System.out.println(Thread.currentThread().getName() + "抢到了车位");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println(Thread.currentThread().getName() + "走了");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            semaphore.release();
                        }
                    },
                    i + "")
                    .start();
        }
    }
}
