package com.mikael.web.action;


import com.mikael.web.bo.Result;
import com.mikael.web.service.Imp.ModeServiceImp;
import com.mikael.web.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mode")
public class Test03Action {
    private static final long serialVersionUID = 1L;
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/test01")
    public Result test01() {
        log.info(applicationContext.getBeanDefinitionCount() + "");
        ModeServiceImp ba = applicationContext.getBean("ModeServiceImp", ModeServiceImp.class);
        ba.test01();

        return ResultUtil.success();
    }
}
