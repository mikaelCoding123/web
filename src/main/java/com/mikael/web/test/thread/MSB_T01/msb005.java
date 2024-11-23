package com.mikael.web.test.thread.MSB_T01;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 一个固定容量的容器，有生产者跟消费者，统计三个方法 生产者模式 跟消费者模式
 *
 * @author Administrator
 */
public class msb005<T> {
    private final int max = 10;
    private final LinkedList<T> lists = new LinkedList<T>();
    private int count = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition pro = lock.newCondition(); // 生产者
    private final Condition consumer = lock.newCondition(); // 消费者

    public T get() {
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0) { // 为什么不用if  两个add线程同时唤醒时 且都是代码执行都｛｝下面了就会不出错
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            pro.signalAll(); // 通知生产者进行生产
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return t;
    }

    public void add(T t) {
        try {
            lock.lock();
            while (lists.size() == max) {
                pro.await();
            }
            lists.add(t);
            ++count;
            /*			System.out.println("xiaofei");
             */
            consumer.signalAll(); // 通知消费者进行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        msb005<String> m = new msb005<>();
        // 启动消费者
        for (int i = 0; i < 2; i++) {
            new Thread(
                    () -> {
                        for (int j = 0; j < 5; j++)
                            System.out.println(m.get() + "    comcount   " + m.count);
                        /*				System.out.println("com");
                         */
                    },
                    "com" + i)
                    .start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 启动生产者
        for (int i = 0; i < 2; i++) {
            new Thread(
                    () -> {
                        for (int j = 0; j < 25; j++) {
                            m.add(Thread.currentThread().getName() + " " + j);
                            System.out.println(" prcount   " + m.count);
                        }
                    },
                    "pro" + i)
                    .start();
        }
    }
}
