package com.mikael.web.component.conadvice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@ControllerAdvice
public class ControllerAdvice01 {
    @ExceptionHandler
    public String handleException(Exception e) {

        return "error";
    }


}
