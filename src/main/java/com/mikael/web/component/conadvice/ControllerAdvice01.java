package com.mikael.web.component.conadvice;

import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 注意不要重复获取异常，容易形成嵌套死循环
 * <p>
 * 容易被切面吞了异常导致不执行
 */
@Slf4j
@RestControllerAdvice
public class ControllerAdvice01 {
    //获取到UNAUTHORIZED跳到指定的错误页面
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "找不到服务")
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("ControllerAdvice01==============ArithmeticException===");
        return ResultUtil.error(e.getMessage());
    }

    @ExceptionHandler(BizException.class)
    public Result handleBizException(BizException e) {
        return ResultUtil.error(e);
    }


}
