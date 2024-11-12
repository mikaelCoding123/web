package com.mikael.web.action;

import cn.hutool.extra.spring.SpringUtil;
import com.mikael.web.service.Imp.Test001ServiceImp;
import com.mikael.web.service.Imp.Test01ServiceImp;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/s")
public class HttpStatusAction {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @GetMapping(value = "/401s")
    public Result test500() {
        return ResultUtil.error();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping(value = "/400s")
    public Result test404() {
        return ResultUtil.error();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping(value = "/500s")
    public Result test400() {
        return ResultUtil.error();
    }



    @Async
    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public Result test01(){
        Test001ServiceImp test001ServiceImp = (Test001ServiceImp) SpringUtil.getBean("Test001ServiceImp");
        System.out.println(test001ServiceImp.test01());
        Optional optional = Optional.ofNullable(SpringUtil.getBean("test01"));
        if (optional.isPresent()){
            return ResultUtil.put(200,"success",optional.get());
        }else {
            return ResultUtil.error();
        }




    }



}
