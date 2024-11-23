package com.mikael.web.test.thread.day006;

/**
 * 采用dcl(双端检锁机制)+volatile来实现在多线程环境下的单例
 */
public class SinglonModel2 {

    private static volatile SinglonModel2 singlonModle2 = null;

    public SinglonModel2() {
    }

    public static SinglonModel2 getInstance() {

        if (singlonModle2 == null) {
            synchronized (SinglonModel2.class) {
                if (singlonModle2 == null) {
                    singlonModle2 = new SinglonModel2();
                }
            }
        }
        return singlonModle2;
    }
}

/**
 * 测试
 */
class SinglonModel2Test {

    public static void main(String[] args) {

        for (int i = 0; i < 100000000; i++) {

            new Thread(
                    () -> {
                        if (SinglonModel2.getInstance() != SinglonModel2.getInstance()) {
                            System.out.println("不满足多线程的单例");
                        }
                    },
                    String.valueOf(i))
                    .start();
            //
        }
    }
}
