package com.mikael.web.action;

import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/s")
public class HttpStatusAction {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @GetMapping(value = "/401s")
    public Result test500() {
        return ResultUtil.error();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @GetMapping(value = "/400s")
    public Result test404() {
        return ResultUtil.error();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @GetMapping(value = "/500s")
    public Result test400() {
        return ResultUtil.error();
    }




}
