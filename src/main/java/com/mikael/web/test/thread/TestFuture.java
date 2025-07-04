package com.mikael.web.test.thread;

import java.util.concurrent.*;

public class TestFuture {

    public static void main(String[] args) {

        //实现一个Callable接口
        Callable<User> c = () -> {
            //这里是业务逻辑处理

            //让当前线程阻塞1秒看下效果
            Thread.sleep(1_000);
            return new User("张三");
        };

        ExecutorService es = Executors.newFixedThreadPool(2);

        // 记得要用submit，执行Callable对象
        Future<User> fn = es.submit(c);
        Future<User> fnn = es.submit(c);
        // 一定要调用这个方法，不然executorService.isTerminated()永远不为true
        es.shutdown();
        // 无限循环等待任务处理完毕  如果已经处理完毕 isDone返回true
        while (!fn.isDone()) {
            System.out.println("fn 处理中...");
        }
        System.out.println("================");
        while (!fnn.isDone()) {
            System.out.println("fnn 处理中...");
        }
        System.out.println("=sf==============");
        try {
            //处理完毕后返回的结果
            User nt = fn.get();
            System.out.println("fn");
            System.out.println(nt.name);
            //处理完毕后返回的结果
            User ntn = fnn.get();
            System.out.println("fnn");
            System.out.println(ntn.name);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class User {
        private final String name;

        private User(String name) {
            this.name = name;
        }
    }
}