package com.mikael.web.action;


import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;


//https://mp.weixin.qq.com/s/r0fV4gnvFv2NfrL03LXEOw
@RestController
@RequestMapping("/asy")
public class AsyncAction {


    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public Callable<Result> test01() {

        return () -> {
            Thread.sleep(1000);
            return ResultUtil.success();
        };

    }

    @GetMapping("/test02")
    public WebAsyncTask<Result> test02() {
        WebAsyncTask<Result> resultWebAsyncTask= new WebAsyncTask<>(()->{
            Thread.sleep(1000);

        return ResultUtil.success();

        });

        resultWebAsyncTask.onTimeout(()->{
            System.out.println("timeout !!!!!");
            return ResultUtil.success();
        });

        return resultWebAsyncTask;
    }
}
