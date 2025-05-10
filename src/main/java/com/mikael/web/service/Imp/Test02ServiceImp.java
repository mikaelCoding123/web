package com.mikael.web.service.Imp;

import com.mikael.web.utils.result.ServiceResult;
import com.mikael.web.service.Test01Service;
import org.springframework.stereotype.Service;

@Service("Test02ServiceImp")
public class Test02ServiceImp implements Test01Service {
    @Override
    public String test01() {
        return "75643";
    }

    @Override
    public ServiceResult test02() {
        return null;
    }
}
