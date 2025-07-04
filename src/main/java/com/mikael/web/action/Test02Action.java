package com.mikael.web.action;

import com.mikael.web.service.Test02Service;
import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test02")
public class Test02Action {

    private static final Logger log = LoggerFactory.getLogger(Test02Action.class);
    @Autowired
    private Test02Service test02Service;


    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public Result test01() throws InterruptedException {

        log.info("test01====" + Thread.currentThread());
        log.info("test01======" + MDC.get("traceId"));
        Result result = test02Service.test02();
        System.out.println(result);
        Result build = Result.builder().code(4893418).build();

        build.setCode(453).setMsg("fjklasf").setData("fjiw222222").setTraceId(MDC.get("traceId"));

        return build;
    }

    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    public Result test02() throws InterruptedException {
        Result result = test02Service.test02();
        Thread.sleep(10000);
        return result;
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public void test03() throws InterruptedException {

        throw new BizException("ksljfiowjklsjf");
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "服务休息了 ")
    public String bizException(BizException e) {
        return e.getMessage();
    }


}
