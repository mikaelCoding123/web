package com.mikael.web.action;

import com.mikael.web.test.bo.User;
import com.mikael.web.utils.result.ServiceResult;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @version 1.0
 * @date 2025/5/9
 */

@RestController
@RequestMapping("/caff")
public class CaffeiAction {

    @Resource
    private CaffeineCacheManager caffeineManager;


    @RequestMapping("/cache/01")
    public ServiceResult cache01(){

        User user = new User(89, "徐莫哦", 12);
        System.out.println("......."+user.toString());
        return ResultUtil.success(user);
    }

    @RequestMapping("/cache/02")
    public ServiceResult cache02(){
        caffeineManager.getCache("");
        System.out.println(".............");
        return ResultUtil.success();
    }



}
