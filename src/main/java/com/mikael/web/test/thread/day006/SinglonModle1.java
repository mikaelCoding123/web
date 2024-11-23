package com.mikael.web.test.thread.day006;

/**
 * 单例+懒加载(采用内部类的方法满足多线程中的单例)
 */
public class SinglonModle1 {

    private SinglonModle1() {
    }

    public static SinglonModle1 getInstance() {

        return InstanceHolder.SINGLON_MODLE_1;
    }

    private static class InstanceHolder {
        private static final SinglonModle1 SINGLON_MODLE_1 = new SinglonModle1();
    }
}

/*测试*/
class SinglonModelTest {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            new Thread(
                    () -> {
                        if (SinglonModle1.getInstance() == SinglonModle1.getInstance()) {
                            System.out.println("满足多线程的单例");
                        }
                    },
                    String.valueOf(i))
                    .start();
            //
        }
    }
}
