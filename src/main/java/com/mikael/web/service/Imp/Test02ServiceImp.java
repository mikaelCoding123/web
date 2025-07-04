package com.mikael.web.service.Imp;

import com.mikael.web.service.Test01Service;
import com.mikael.web.utils.result.Result;
import org.springframework.stereotype.Service;

@Service("Test02ServiceImp")
public class Test02ServiceImp implements Test01Service {
    @Override
    public String test01() {
        return "75643";
    }

    @Override
    public Result test02() {
        return null;
    }
}
