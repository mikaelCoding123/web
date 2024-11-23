package com.mikael.web.test.thread.forkjoin;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ForkjoinTest
 * @packageName: thread.forkjoin
 * @description:
 * @date: 2021-01-17
 *
 * ForkJoinPool()最适合的是计算密集型的任务
 */
public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] i = {1, 2, 312, 23};
        System.out.println(Arrays.toString(i));
        // 生成数组
        int[] a = gennerateArray(150, 34);
        // System.out.println("单线程执行结果: " + ArrayUtils.sum(a));
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask task = new SumTask(a, 0, a.length - 1);
        // 提交任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        System.out.println("fork.join执行结果: " + result.get());

        System.out.println("===============");
        System.out.println(computer(a));
    }

    // 生成的数组
    public static int[] gennerateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    //jdk8 并行流计算
    public static int computer(int[] arrs){
        long l = System.currentTimeMillis();
        int count = Arrays.stream(arrs).parallel().reduce(0, Integer::sum);
        System.out.println(System.currentTimeMillis() - l);
        return count;
    }
}

//没有返回值
class su extends RecursiveAction{

    @Override
    protected void compute() {

    }
}

//有返回值
class SumTask extends RecursiveTask<Integer> {

    private final int THREHOLD = 10;
    private final int[] src;
    private final Integer left;
    private final Integer right;

    public SumTask(int[] src, Integer left, Integer right) {
        this.src = src;
        this.left = left;
        this.right = right;
    }

    @Override
    protected Integer compute() {

        if ((right - left) < THREHOLD) {
            Integer sum = 0;
            System.out.println(left + " to " + right);
            for (int i = left; i <= right; i++) {
                sum += src[i];
            }
            return sum;
        }
        // 拆分数组
        Integer mid = (left + right) >> 1;
        SumTask leftTask = new SumTask(src, left, mid);
        SumTask rightTask = new SumTask(src, mid + 1, right);
        invokeAll(leftTask, rightTask);
        return leftTask.join() + rightTask.join();
    }
}

class SumTask1 extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {

        return null;
    }
}
