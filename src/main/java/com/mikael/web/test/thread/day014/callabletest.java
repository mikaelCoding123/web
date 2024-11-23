package com.mikael.web.test.thread.day014;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class callabletest implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t come in callable");
        return 1024;
    }
}

class TestCall {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> integerFutureTask = new FutureTask<>(new callabletest());
        FutureTask<Integer> integerFutureTask2 = new FutureTask<>(new callabletest());
        FutureTask<Integer> integerFutureTask3 = new FutureTask<>(new callabletest());
        Thread t1 = new Thread(integerFutureTask, "a");
        Thread t2 = new Thread(integerFutureTask, "b");
        t1.start();
        t2.start();
        /** ***************以上方法只能有一个进入了callable线程*************************************** */
        Thread t3 = new Thread(integerFutureTask2, "c");
        Thread t4 = new Thread(integerFutureTask3, "d");
        t3.start();
        t4.start();
        /** ***************t3,t4 两个都进入了callable线程*************************************** */
        while (!integerFutureTask.isDone()) {
            integerFutureTask.get();
        }

        integerFutureTask.get(); // 该方法是线程还没有结束,就去寻找结果,导致阻塞,一般放在最后或者如上用while控制
    }
}
