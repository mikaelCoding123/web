package com.mikael.web.action;


import cn.hutool.core.util.IdUtil;
import com.mikael.web.bo.Admin;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;


//https://mp.weixin.qq.com/s/r0fV4gnvFv2NfrL03LXEOw
@RestController
@Slf4j
@RequestMapping("/asy")
public class AsyncAction {


  public static void main(String[] args) {
    ConcurrentHashMap<String, Admin> concurrentHashMap = new ConcurrentHashMap<>(16000);
    long time = System.nanoTime();
    for (int i = 0; i < 16000; i++) {
      Admin admin = new Admin(i, "is" + i, IdUtil.fastSimpleUUID());
      concurrentHashMap.put(i + "", admin);
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(concurrentHashMap.get(1 + "").getId());
    }
    System.out.println(System.nanoTime() - time);


  }

  @RequestMapping(value = "/test01", method = RequestMethod.GET)
  public Callable<Result> test01() {

    log.info("asy/test01================");
    return () -> {
      log.info("asy/test01================");
      Thread.sleep(1000);
      return ResultUtil.success();
    };

  }

  @GetMapping("/test02")
  public WebAsyncTask<Result> test02() {
    WebAsyncTask<Result> resultWebAsyncTask = new WebAsyncTask<>(() -> {
      Thread.sleep(1000);

      return ResultUtil.success();

    });

    resultWebAsyncTask.onTimeout(() -> {
      System.out.println("timeout !!!!!");
      return ResultUtil.success();
    });

    return resultWebAsyncTask;
  }

  @GetMapping("/test03")
  public Result test03() {
    synchronized (this) {
      log.info("shiel");
    }

    save();

    return ResultUtil.success();
  }

  private void save() {
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Async
  @RequestMapping(value = "/asy01", method = RequestMethod.GET)
  public CompletableFuture<Result> asy01() throws InterruptedException {
    Thread.sleep(4_000L);

    return CompletableFuture.completedFuture(ResultUtil.success());
  }

}
