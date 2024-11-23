package com.mikael.web.test.thread.day006;

/**
 * 枚举创建单例
 */
public class SinglonMenu {

    private SinglonMenu() {
    }

    public static SinglonMenu getInstance() {
        return SinglonMenu.getInstance();
    }

    private enum Singleton {
        INSTANCE;
        private final SinglonMenu instance;

        Singleton() {
            instance = new SinglonMenu();
        }

        public SinglonMenu getInstance() {
            return instance;
        }
    }
}

/*测试*/
class SinglonMenuTest {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {

            new Thread(
                    () -> {
                        if (SinglonMenu.getInstance() != SinglonMenu.getInstance())
                            System.out.println("不满足多线程的单例");
                    },
                    String.valueOf(i))
                    .start();
            //
        }
    }
}
