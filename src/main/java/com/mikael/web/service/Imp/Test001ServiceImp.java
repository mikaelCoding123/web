package com.mikael.web.service.Imp;

import com.mikael.web.service.Test02Service;
import com.mikael.web.utils.result.Result;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("Test001ServiceImp")
public class Test001ServiceImp implements Test02Service {

    @Resource
    private ZeRenLianHandle zeRenLianHandle;

    @Override
    public String test01() {
        return "Test00ServiceImp";
    }

    @Cacheable(cacheNames = "compositeCacheManager", cacheManager = "compositeCacheManager")
    @Override
    public Result test02() throws InterruptedException {

        Result result = new Result();
        result.setCode(111);
        Thread.sleep(4_000L);
        return result;
    }

    @Override
    public Result test03() {
        zeRenLianHandle.execute("test03");
        return null;
    }
}
