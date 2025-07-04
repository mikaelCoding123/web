package com.mikael.web.action;

import com.mikael.web.service.ThreadService;
import com.mikael.web.test.bo.User;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/thread")
public class ThreadAction {

    @Resource
    private ThreadService threadService;

    @GetMapping("test01")
    public Result test01() throws Exception {
        threadService.run(new User(100, "hua,", 288));
        return ResultUtil.success();
    }

}
