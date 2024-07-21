package com.mikael.web.action;

import com.mikael.web.utils.result.Result;
import com.mikael.web.service.Test02Service;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/r")
public class Test02Action {

    @Resource
    private  Test02Service test02Service;


    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public Result test01(){
        Result result = test02Service.test02();
        System.out.println("748456");
        return result;
    }

    @RequestMapping(value = "/test02",method = RequestMethod.GET)
    public Result test02() throws InterruptedException {
        Result result = test02Service.test02();
        Thread.sleep(10000);
        return result;
    }



}
