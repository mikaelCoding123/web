package com.mikael.web.action;


import com.mikael.web.utils.result.ServiceResult;

import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/redis")
public class Redis01Action {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public ServiceResult test() {

        redisTemplate.opsForValue().set("2", "hua");
        log.info((String) redisTemplate.opsForValue().get("2"));

        return ResultUtil.success();
    }
}
