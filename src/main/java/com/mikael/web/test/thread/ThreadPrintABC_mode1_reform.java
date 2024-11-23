package com.mikael.web.test.thread;

import java.util.concurrent.TimeUnit;

/**
 * 多个线程按顺序循环执行采用sleep形式 "abcdef" "123456" 两个数组 输出“a1b2c3d4”
 */
public class ThreadPrintABC_mode1_reform {
    enum ReadytoRun {
        t1,
        t2,
        t3
    }

    // 不使用volatile 时，会造成死锁
    static volatile ReadytoRun t = ReadytoRun.t1;

    public static void main(String[] args) {
        char[] chars = "abcdef".toCharArray();
        char[] chars1 = "123456".toCharArray();
        char[] chars2 = "ABCDEF".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            new Thread(
                    () -> {
                        for (char c : chars) {
                            while (t != ReadytoRun.t1) {
                            }
                            System.out.print(c);
                            t = ReadytoRun.t2;
                        }
                    },
                    "b")
                    .start();
            new Thread(
                    () -> {
                        for (char c : chars1) {
                            while (t != ReadytoRun.t2) {
                            }
                            System.out.print(c);
                            t = ReadytoRun.t3;
                        }
                    },
                    "a")
                    .start();
            new Thread(
                    () -> {
                        for (char c : chars2) {
                            while (t != ReadytoRun.t3) {
                            }
                            System.out.print(c);
                            if (c == 'F') System.out.println();

                            t = ReadytoRun.t1;
                        }
                    },
                    "c")
                    .start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
