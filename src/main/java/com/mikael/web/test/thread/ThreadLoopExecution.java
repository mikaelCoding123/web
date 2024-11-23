/**
 * projectName: JUC fileName: ThreadLoopExecution.java packageName: Thread date: 2020-09-11
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.web.test.thread;

import java.util.concurrent.Semaphore;

/**
 * @version: V1.0
 * @author: mikael
 * @className: ThreadLoopExecution
 * @packageName: Thread
 * @description: 线程循环执行信号量版本
 * @date: 2020-09-11
 */
public class ThreadLoopExecution {

    char[] chars = "abcdef".toCharArray();
    char[] chars1 = "123456".toCharArray();
    char[] chars2 = "ABCDEF".toCharArray();
    private static final Semaphore s1 = new Semaphore(1);
    private static final Semaphore s2 = new Semaphore(1);
    private static final Semaphore s3 = new Semaphore(1);

    Thread t1 =
            new Thread(
                    () -> {
                        while (true) {
                            for (int i = 0; i < chars.length; i++) {
                                try {
                                    s1.acquire();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.print(chars[i]);
                                s2.release();
                            }
                        }
                    },
                    "T1");

    Thread t2 =
            new Thread(
                    () -> {
                        while (true) {
                            for (int i = 0; i < chars.length; i++) {
                                try {
                                    s2.acquire();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.print(chars1[i]);
                                s3.release();
                            }
                        }
                    },
                    "T2");

    Thread t3 =
            new Thread(
                    () -> {
                        while (true) {
                            for (int i = 0; i < chars.length; i++) {
                                try {
                                    s3.acquire();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.print(chars2[i]);
                                s1.release();
                            }
                        }
                    },
                    "T3");

    private void fun() throws InterruptedException {
        s2.acquire();
        s3.acquire();
        t2.start();
        t3.start();
        t1.start();
//    s2.acquire();
//    s3.acquire();
//    // s2.acquire();
//    t1.start();
//    t2.start();
//    t3.start();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLoopExecution threadLoopExecution = new ThreadLoopExecution();
        long l = System.currentTimeMillis();
        threadLoopExecution.fun();
        while (true) {
            if (System.currentTimeMillis() - l > 3) {
                System.exit(0);
            }
        }
    }
}
