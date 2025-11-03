package com.mikael.web.action;


import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.redisson.RedissonMultiLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/red")
@Slf4j
public class RedissonAction {

  @Resource
  private RedissonClient redisson;

  public static void main(String[] args) {
    long time = System.currentTimeMillis();
    long a = 20659754333L;
    System.out.println(time * ThreadLocalRandom.current().nextInt(10000) * 10000);
  }

  //https://www.cnblogs.com/wq-9/articles/16423575.html
  //https://blog.csdn.net/yuxiangdeming/article/details/134037685
  @RequestMapping("/test01")
  public Result Test01() throws InterruptedException {
    RedissonMultiLock redissonMultiLock = new RedissonMultiLock();
    redissonMultiLock.tryLock();
    //创建锁
    RLock goodsLock = redisson.getLock("goods_id_1254215231");
    boolean b = goodsLock.tryLock(3L, TimeUnit.SECONDS);
    try {
      // 为true 表示锁可用
      if (b) {
        log.info("test01....lock.业务代码..");
        Thread.sleep(5000L);
      }
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      //释放锁
      goodsLock.unlock();
      log.info("test01.....unlock...");
    }


    return ResultUtil.success();
  }

  //    秒杀
  @PostMapping("/v1/kill/{id}")
  public Result SecKill(@PathVariable("id") String id, HttpServletRequest request) {
    String sessionId = request.getSession().getId();
    //一、锁

    //二、判
    //三、更新


    return ResultUtil.success();
  }


}
