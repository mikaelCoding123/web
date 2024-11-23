package com.mikael.web.test.thread.Demo1.day01;

import java.util.concurrent.TimeUnit;

public class msb006 {
    /*volatile*/ boolean flag = true;

    // volatile 通知其他线程在cpu缓冲区中的数据发生改变，需重新从线程中读取  也称无锁同步  （查看原子类）sycn中的的代码
    // 块越少越好
    // 不要以字符串常量为锁的对象
    // wait 和
    synchronized void m() {
        System.out.println("m start!!!");
        while (flag) {
        }
        System.out.println("m end!!!");
    }

    public static void main(String[] args) {
        msb006 t = new msb006();

        new Thread(
                new Runnable() {
                    public void run() {
                        t.m();
                    }
                })
                .start();
        // 该段时间暂停就是为了防止线程空闲时去查看flag的值是否发生变化
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
    }
}
