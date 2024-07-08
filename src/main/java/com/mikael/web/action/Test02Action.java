package com.mikael.web.action;

import com.mikael.web.bo.Result;
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


    @RequestMapping(value = "/test02",method = RequestMethod.GET)
    public Result test01(){
        Result result = test02Service.test02();
        return result;
    }



}
