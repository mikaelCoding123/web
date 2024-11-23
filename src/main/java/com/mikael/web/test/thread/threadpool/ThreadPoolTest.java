/*
 * projectName: JUC
 * fileName: ThreadPoolTest.java
 * packageName: Thread.threadpool
 * date: 2020-11-05
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.web.test.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ThreadPoolTest
 * @packageName: Thread.threadpool
 * @description:
 * @date: 2020-11-05
 */
public class ThreadPoolTest {


    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        1,
                        2,
                        4,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<Runnable>(3),
                        new MyRejectedExecutionHandler());

        List<Future<String>> futurelist = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            try {
                futurelist.add(executor.submit(new T1()));

                futurelist.add(executor.submit(new T2()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("结束1。。。");
        for (Future future : futurelist) {
            if (future.isDone()) {
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("结束2.。。。。。");
    }
}

class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    }
}

class T1 implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("1111");
        return "t1....";
    }
}


class T2 implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("2222");
        return "t2....";
    }
}