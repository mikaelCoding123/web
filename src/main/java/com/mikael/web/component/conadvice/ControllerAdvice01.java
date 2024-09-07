package com.mikael.web.component.conadvice;

import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ControllerAdvice01 {
    @ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "找不到服务")
    @ExceptionHandler(BizException.class)
    public String handleException(Exception e) {
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(){
        return ResultUtil.error();
    }


}
