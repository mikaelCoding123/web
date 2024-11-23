package com.mikael.web.test.thread.day015;

/**
 * Executors.newScheduledThreadPool(7);
 *
 * <p>Executors.newWorkStealingPool( 7);
 *
 * <p>newFixedThreadPool(int i) ----> 一池固定处理线程 执行长期任务
 *
 * <p>newSingleThreadExecutor ----->一池一个线程 一个任务一个任务执行的场景
 *
 * <p>newCachedThreadPool ------> 一池n个线程 执行很多短期异步的小程序或者负载较轻的服务器
 *
 * <p>
 *
 * <p>工作中一个创建方式都不用,而是用 ThreadPoolExecutor 自行创建线程池 因为 以上创建中欧有一个阻塞队列 ,而阻塞对列是的界限太大
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreaPool {

    public static void main(String[] args) {

        //        ExecutorService executorService =Executors.newScheduledThreadPool(7);

        // ExecutorService executorService = Executors.newWorkStealingPool( 7);

        // ExecutorService executorService = Executors.newFixedThreadPool(5);

        // ExecutorService executorService =Executors.newSingleThreadExecutor();

        ExecutorService executorService = Executors.newCachedThreadPool(); // 该方法的线程池会自己扩容 灵活

        // ExecutorService executorService1 = new ThreadPoolExecutor(7大参数); 用该方法实现为最佳

        for (int i = 0; i < 10; i++) {
            executorService.execute(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + "\t 工作");
                    });
        }
    }
}
