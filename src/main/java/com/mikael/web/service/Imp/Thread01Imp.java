package com.mikael.web.service.Imp;

import com.mikael.web.test.bo.User;
import com.mikael.web.utils.result.Result;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class Thread01Imp implements Callable{

    private User user;
    private Integer integer;

    public Thread01Imp(User user, Integer integer) {
        this.user = user;
        this.integer = integer;
    }


    @Override
    public Result call() throws Exception {
        log.info(user.getName()+"====="+integer);

        return null;
    }
}
