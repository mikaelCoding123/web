package com.mikael.web.service.Imp;

import com.mikael.web.bo.Result;
import com.mikael.web.service.Test01Service;
import org.springframework.context.annotation.Primary;
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
