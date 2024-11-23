package com.mikael.web.test.thread.threadpool;

//https://ethendev.github.io/2018/07/20/java-task-with-result/

import java.util.concurrent.*;

/**
 * @author mikael
 */
public class ThreadPool {
    private final ExecutorService executor = Executors.newFixedThreadPool(2);
    // 定义任务:
    private static final Callable<String> task = new Task();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Thread01(task));
        executor.submit(new Thread02());


// 提交任务并获得Future
        Future<String> future = executor.submit(task);
// 从Future获取异步执行返回的结果:
        try {
            String result = future.get(); // 可能阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //
    }
}

class Thread01 implements Runnable {
    private final Callable<String> task;


    public Thread01(Callable<String> task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("thread01++++++");

    }

}


class Thread02 implements Runnable {

    @Override
    public void run() {
        System.out.println("thread01++++++");
    }
}


class Task implements Callable<String> {
    public String call() throws Exception {
        return longTimeCalculation();
    }

    private String longTimeCalculation() {
        return "task.......";
    }
}