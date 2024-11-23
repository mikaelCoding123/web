package com.mikael.web.test.thread.day005;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

public class CapterService2 {

    private static final LinkedList<Locker> lockers = new LinkedList<>();

    public static void main(String[] args) {

        LinkedList<Thread> list = new LinkedList<>();

        Arrays.asList("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10").stream()
                .map(CapterService2::CreateThread)
                .forEach(
                        t -> {
                            t.start();
                            list.add(t);
                        });

        Optional.of("this thread  " + Thread.currentThread().getName() + "  整体结束 ！！！")
                .ifPresent(System.out::println);
    }

    private static Thread CreateThread(String Name) {
        return new Thread(
                () -> {
                    Optional.of("this thread  " + Thread.currentThread().getName() + "  线程开始执行 ！！！")
                            .ifPresent(System.out::println);

                    synchronized (lockers) {
                        while (lockers.size() > 4) {
                            try {
                                lockers.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        lockers.addLast(new Locker());
                    }

                    Optional.of("this thread  " + Thread.currentThread().getName() + "  正在执行 ！！！")
                            .ifPresent(System.out::println);

                    synchronized (lockers) {
                        Optional.of("this thread  " + Thread.currentThread().getName() + " 执行结束 ！！！")
                                .ifPresent(System.out::println);
                        lockers.notifyAll();
                        lockers.removeFirst();
                    }
                },
                Name);
    }

    private static class Locker {
    }
}
