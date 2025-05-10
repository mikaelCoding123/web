package com.mikael.web.action;

import cn.hutool.extra.spring.SpringUtil;
import com.mikael.web.service.Imp.Test001ServiceImp;
import com.mikael.web.utils.result.ServiceResult;
import com.mikael.web.utils.result.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/s")
public class HttpStatusAction {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @GetMapping(value = "/401s")
    public ServiceResult test500() {
        return ResultUtil.error();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping(value = "/400s")
    public ServiceResult test404() {
        return ResultUtil.error();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping(value = "/500s")
    public ServiceResult test400() {
        return ResultUtil.error();
    }

    @RequestMapping(value = "/responseEntity",method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> responseEntity(){

        return  ResponseEntity.ok(ResultUtil.success());
    }



    @Async
    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public ServiceResult test01(){
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
