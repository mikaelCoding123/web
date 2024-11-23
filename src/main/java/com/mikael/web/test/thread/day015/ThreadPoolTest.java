package com.mikael.web.test.thread.day015;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mikael
 */
// 防止出现java.util.concurrent.RejectedExecutionException的错误，尽量将maximumPoolSize 的值设置大点
public class ThreadPoolTest {
    public static void main(String[] args) {
        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,TimeUnit.MICROSECONDS,new
        // ArrayBlockingQueue<Runnable>(5));
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 20, 200, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(18));
        if (!executor.isShutdown()) { // executor.isShutdown()
            for (int i = 0; i < 15; i++) {
                Threadtask threadtask = new Threadtask();
                executor.execute(threadtask);
                executor.execute(new Threadtask2());
                // System.out.println(executor.getActiveCount() + "活跃的数目");
                System.out.println(executor.getQueue().size() + "排队的个数");
                System.out.println(executor.getCompletedTaskCount() + "完成的个数");
            }
        }
        System.out.println("整体结束------------");
        executor.shutdown();
    }
}

class Threadtask implements Runnable {

    private int tasknum;

    public Threadtask() {
    }

    @Override
    public void run() {
        System.out.println("running!!!!\t" + tasknum);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finsh thread\t" + Thread.currentThread().getName());
    }
}

class Threadtask2 implements Runnable {

    private int tasknum;

    public Threadtask2() {
    }

    @Override
    public void run() {
        System.out.println("线程2 running!!!!\t" + tasknum);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程2 finish\t" + Thread.currentThread().getName());
    }
}
