package com.mikael.web.test.thread.day009;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Test {
    public static void main(String[] args) {
        //
        AtomicStampedReference<Boolean> atomicStampedReference = new AtomicStampedReference<>(false, 1);

        for (int i = 0; i < 20; i++) {

            new Thread(
                    () -> {
                        if (atomicStampedReference.compareAndSet(false, true, 1, 2)) {

                            System.out.println("对了");
                        }
                    })
                    .start();
        }
    }
}
