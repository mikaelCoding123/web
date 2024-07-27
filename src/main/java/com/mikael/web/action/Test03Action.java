package com.mikael.web.action;


import com.mikael.web.service.Test02Service;
import com.mikael.web.utils.result.Result;
import com.mikael.web.service.Imp.ModeServiceImp;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/mode")
public class Test03Action {
    private static final long serialVersionUID = 1L;
    @Autowired
    private ApplicationContext applicationContext;

    @Resource
    private Test02Service test02Service;
    @RequestMapping("/test01")
    public Result test01() {
        log.info(applicationContext.getBeanDefinitionCount() + "");
        ModeServiceImp ba = applicationContext.getBean("ModeServiceImp", ModeServiceImp.class);
        ba.test01();
        System.out.println(test02Service.test01());

        return ResultUtil.success();
    }

    /**
     * 责任链
     */
    @RequestMapping(value = "/test02",method = RequestMethod.GET)
    public Result test02() {
        test02Service.test03();
        return ResultUtil.success();
    }
}
