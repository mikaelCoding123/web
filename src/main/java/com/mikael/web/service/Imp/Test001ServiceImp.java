package com.mikael.web.service.Imp;

import com.mikael.web.utils.result.ServiceResult;
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
    public ServiceResult test02() {

        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setCode(111);
        return serviceResult;
    }

    @Override
    public ServiceResult test03() {
        zeRenLianHandle.execute("test03");
        return null;
    }
}
