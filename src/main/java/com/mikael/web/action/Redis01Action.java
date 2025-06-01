package com.mikael.web.action;


import com.mikael.web.service.Imp.Test001ServiceImp;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/redis")
public class Redis01Action {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private Test001ServiceImp test001ServiceImp;

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public Result test() throws InterruptedException {
        redisTemplate.opsForValue().set("2", "hua");
        log.info((String) redisTemplate.opsForValue().get("2"));
        return ResultUtil.success();
    }

    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    public Result test02() {
        redisTemplate.opsForValue().set("2", "hua");
        log.info((String) redisTemplate.opsForValue().get("2"));
        System.out.println();
        return ResultUtil.success();
    }

    // https://zhuanlan.zhihu.com/p/385515782
    //    value的值要跟config中的 new CaffeineCacheManager("aa") 相同
    @Cacheable(value = "aa")
    @RequestMapping(value = "/caffeine01", method = RequestMethod.GET)
    public Result test03() throws InterruptedException {
        Thread.sleep(2000);
        return ResultUtil.success("855456");
    }

    //    这个id相当于 map中的key
    @CacheEvict(value = "aa",key = "#id") // 删除缓存
    @Cacheable(value = "aa", key = "#id")
    @RequestMapping(value = "/caffeine02", method = RequestMethod.GET)
    public Result test04(@RequestParam("id") String id) throws InterruptedException {
        Thread.sleep(2000);
        return ResultUtil.success("test04.....");
    }

    @RequestMapping(value = "/caffeine03", method = RequestMethod.GET)
    public Result test05(@RequestParam("id") String id) throws InterruptedException {
        Result result = test001ServiceImp.test02();
        return ResultUtil.success(result);
    }



}
