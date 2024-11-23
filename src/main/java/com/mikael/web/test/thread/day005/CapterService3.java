package com.mikael.web.test.thread.day005;

import java.util.*;

/**
 * 多个生产者,多个消费者
 */
public class CapterService3 {

    private static final LinkedList<Locker2> locker2s = new LinkedList<>();

    public static void main(String[] args) {

        Collection<Thread> worker = new ArrayList<>();

        Arrays.asList("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10").stream()
                .map(CapterService3::CreateThread)
                .forEach(
                        t -> {
                            t.start();
                            worker.add(t);
                        });
        Optional.of("this worker is over").ifPresent(System.out::println);
    }

    public static Thread CreateThread(String name) {
        return new Thread(
                () -> {
                    Optional.of("this thread is " + Thread.currentThread().getName() + "   创建成功")
                            .ifPresent(System.out::println);
                    synchronized (locker2s) {
                        while (locker2s.size() > 4) {
                            try {
                                locker2s.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        locker2s.add(new Locker2());
                    }

                    Optional.of("this thread is " + Thread.currentThread().getName() + "  正在工作")
                            .ifPresent(System.out::println);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Optional.of("this thread is " + Thread.currentThread().getName() + "  正在工作！！！！")
                            .ifPresent(System.out::println);

                    synchronized (locker2s) {
                        locker2s.notifyAll();
                        locker2s.removeFirst();

                        Optional.of("this thread is " + Thread.currentThread().getName() + "  线程结束任务")
                                .ifPresent(System.out::println);
                    }
                },
                name);
    }

    private static class Locker2 {
    }
}
