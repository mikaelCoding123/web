package com.mikael.web.service.Imp;

import com.mikael.web.service.Test02Service;
import com.mikael.web.utils.result.Result;
import com.mikael.web.service.Test01Service;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("Test01ServiceImp")
public class Test01ServiceImp implements Test01Service {
    private static final Logger log = LoggerFactory.getLogger(Test01ServiceImp.class);

    @Resource
    private Test02Service test02Service;

    @Override
    public String test01() {

        log.info("111111");
        test02Service.test01();

        return "jkfoipw";
    }

    @Override
    public Result test02() {
        return null;
    }
}
