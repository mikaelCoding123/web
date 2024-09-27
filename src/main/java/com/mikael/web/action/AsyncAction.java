package com.mikael.web.action;


import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    private static final Logger log = LoggerFactory.getLogger(AsyncAction.class);

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
}
