package com.mikael.web.component.conadvice;

import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 注意不要重复获取异常，容易形成嵌套死循环
 */
@Slf4j
@ControllerAdvice
public class ControllerAdvice01 {


    @ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "找不到服务")
    @ExceptionHandler(BizException.class)
    public String handleException(BizException e) {
      log.info(e.getMessage()+"======");



        return "error.html";
    }

//    @ExceptionHandler(Exception.class)
//    public Result handleException(Exception e) {
//        return ResultUtil.error(e);
//    }


}
