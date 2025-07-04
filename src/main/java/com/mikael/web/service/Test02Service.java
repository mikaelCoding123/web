package com.mikael.web.service;

import com.mikael.web.utils.result.Result;

public interface Test02Service {
    String test01();

    Result test02() throws InterruptedException;

    Result test03();
}
