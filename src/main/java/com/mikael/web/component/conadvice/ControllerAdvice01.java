package com.mikael.web.component.conadvice;

import com.mikael.web.utils.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@ControllerAdvice
public class ControllerAdvice01 {
    @ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "找不到服务")
    @ExceptionHandler(BizException.class)
    public String handleException(Exception e) {

        return "error";
    }


}
