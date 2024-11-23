package com.mikael.web.test.thread.day010;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * hashset list 非线程安全问题
 * @Exception ConcurrentModificationException  并发时争抢修改
 */
public class containerNotSafeDemo {
    public static void main(String[] args) {
        // 写法一
    /*
        List<String> list = Arrays.asList("a", "b", "c");
        list.forEach(System.out::println);
    */
        //
    /*
    new Vector<>();
    List<String> list3 = Collections.synchronizedList(new ArrayList<>());
    new CopyOnWriteArrayList<>();*/

        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            // 有时会发生java.util.ConcurrentModificationException

            new Thread(
                    () -> {
                        list2.add(UUID.randomUUID().toString().substring(0, 8));
                        Optional.of(list2).ifPresent(System.out::println);
                        // System.out.println(list2);
                    })
                    .start();

            /**
             * UUID 产生一个主键 错误内容: java.util.ConcurrentModificationException
             *
             * <p>导致原因:并发时争抢修改
             *
             * <p>解决方案: new Vector<>() Collections.synchronizedList(new ArrayList<>()); new
             * CopyOnWriteArrayList<>() --这个容器是写时复制容器,往容器添加一个元素时,先复制一个object[],再在新的object[]中添加元素之后,将原容器的引用指向新的容器中,好处是在容器进行并发读时不需要锁,实现了读写分离的思想
             *
             * <p>代替new ArrayList(); 优化建议:
             */
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("***************************************");

        /** hashset底层是hashmap */
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            //
            new Thread(
                    () -> {
                        set.add(UUID.randomUUID().toString().substring(0, 8));
                        Optional.of(set).ifPresent(System.out::println);
                    })
                    .start();
        }

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("***************************************");
        Map map = new HashMap();
        for (int i = 0; i < 10; i++) {
            //
            new Thread(
                    () -> {
                        map.put(
                                Thread.currentThread().getName(), UUID.randomUUID().toString().substring(1, 8));
                        Optional.of(map).ifPresent(System.out::println);
                    })
                    .start();
        }
    }
}
