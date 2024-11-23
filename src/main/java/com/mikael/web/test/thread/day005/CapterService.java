package com.mikael.web.test.thread.day005;

import java.util.*;

/**
 *
 */
public class CapterService {
    private static final LinkedList<Control> controler = new LinkedList<>();

    public static void main(String[] args) {

        List<Thread> control = new ArrayList<>();
        Arrays.asList("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10", "m11").stream()
                .map(CapterService::CreatThread)
                .forEach(
                        t -> {
                            t.start();
                            control.add(t);
                        });
        control.stream()
                .forEach(
                        t -> {
                            try {
                                t.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        });
        Optional.of("thread is    " + Thread.currentThread().getName() + "   整体结束!!!!")
                .ifPresent(System.out::println);
    }

    private static Thread CreatThread(String name) {
        return new Thread(
                () -> {
                    Optional.of("thread is    " + Thread.currentThread().getName() + "   启动!!!!")
                            .ifPresent(System.out::println);
                    synchronized (controler) {
                        while (controler.size() > 5) {
                            try {
                                controler.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        controler.addLast(new Control());
                    }
                    Optional.of("thread is    " + Thread.currentThread().getName() + "   正在工作!!!!")
                            .ifPresent(System.out::println);

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (controler) {
                        Optional.of("thread is    " + Thread.currentThread().getName() + "   结束工作!!!!")
                                .ifPresent(System.out::println);
                        controler.removeFirst();

                        controler.notifyAll();
                    }
                },
                name);
    }
}

class Control {
}
