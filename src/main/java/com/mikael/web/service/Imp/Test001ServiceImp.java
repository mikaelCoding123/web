package com.mikael.web.service.Imp;

import com.mikael.web.utils.result.Result;
import com.mikael.web.service.Test02Service;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service("Test001ServiceImp")
public class Test001ServiceImp implements Test02Service {

    @Resource
    private ZeRenLianHandle zeRenLianHandle;

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

    @Override
    public Result test03() {
        zeRenLianHandle.execute("test03");
        return null;
    }
}
