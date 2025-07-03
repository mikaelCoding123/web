package com.mikael.web.action;

import com.mikael.web.bo.Admin;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


//https://cloud.tencent.com/developer/article/2482007
@RestController
@RequestMapping("/optional")
@Slf4j
public class OptionalAndAssertAction {

    @RequestMapping(value = "/null", method = RequestMethod.GET)
    public Result toNull() {
        Admin admin = new Admin();
        log.info("进入。。。。。。。。。");
        Optional.ofNullable(admin).orElseThrow(() -> new IllegalArgumentException("admin is null"));
        log.info("{}", "admin is null!");

        return ResultUtil.success(admin);
    }
}
