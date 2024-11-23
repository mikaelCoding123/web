package com.mikael.web.test.thread.day012;


import java.util.concurrent.CountDownLatch;

class Add {

    public int anInt(int i) {

        i = i + 1;

        return i;
    }
}

/**
 * countDownLatch.countDown(n); n的值必须从countdown到 0 才停止,否则一直wait
 *
 * <p>放在某件事结束了之后的位置
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        // 一般用法
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i <= 5; i++) {
            //
            new Thread(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + "\t 出去了");
                        countDownLatch.countDown();
                    })
                    .start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" ++++++++" + Thread.currentThread().getName());
        // 枚举用法
        /** PersonEnum.getPersonEnum(i)中的i 需要与枚举中的Code变量一直 */
        CountDownLatch countDownLatchEnum = new CountDownLatch(5);
        for (int i = 1; i <= 4; i++) {
            new Thread(
                    () -> {
                        System.out.println(Thread.currentThread().getName() + "\t 出去了");
                        countDownLatchEnum.countDown();
                    },
                    PersonEnum.getPersonEnum(i).getNeme())
                    .start();
        }

        try {
            countDownLatchEnum.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" +++Enum+++++" + Thread.currentThread().getName());
    }
}
