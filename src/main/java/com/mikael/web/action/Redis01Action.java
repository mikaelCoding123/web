package com.mikael.web.action;


import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/redis")
public class Redis01Action {

    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public Result test(){

        throw new BizException("错误");
    }
}
