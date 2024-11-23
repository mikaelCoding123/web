package com.mikael.web.test.thread.Demo1.day01;

/**
 * synchronized 锁的是一个对象
 *
 * @author Administrator
 */
public class msb001 {
    private int count = 10;
    private final Object object = new Object();

    private void m() {
        synchronized (object) { // 相要执行｛｝下的代码先去堆中神器object的锁    object一般用this代替
            count--;
            System.out.println(Thread.currentThread().getName() + "count=" + count);
        }
    }

    public static void main(String[] args) {
        new msb001().m();
    }
}
