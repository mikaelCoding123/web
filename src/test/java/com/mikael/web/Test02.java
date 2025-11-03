package com.mikael.web;

import lombok.SneakyThrows;

/**
 * @author
 * @version 1.0
 * @date 2025/7/14
 */

public class Test02 {
  @SneakyThrows
  public static void main(String[] args) {
    ThreadLocal<Integer> mapThreadLocal = new ThreadLocal<Integer>();
    mapThreadLocal.set(1);
    new Thread(() -> {
      mapThreadLocal.set(2);

      System.out.println(mapThreadLocal.get());
    }).start();
    new Thread(() -> {
      mapThreadLocal.set(3);

    }).start();
    Thread.sleep(3);
    System.out.println(mapThreadLocal.get());


  }

}
