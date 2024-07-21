package com.mikael.web.service.Imp;

import com.mikael.web.utils.result.Result;
import com.mikael.web.service.Test02Service;
import org.springframework.stereotype.Service;


@Service("Test001ServiceImp")
public class Test001ServiceImp implements Test02Service {
    @Override
    public String test01() {
        return "Test00ServiceImp";
    }

    @Override
    public Result test02() {

        Result result = new Result();
        result.setCode(111);
        return result;
    }
}
