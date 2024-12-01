package com.mikael.web.action;


import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/redis")
public class Redis01Action {


    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public Result test(){

        try {
            int i =1/0;
        } catch (Exception e) {
            throw new BizException(e);
        }


        return ResultUtil.success();
    }
}
