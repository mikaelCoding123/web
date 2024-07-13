package com.mikael.web.action;


import com.mikael.web.bo.Result;
import com.mikael.web.service.Imp.Test01ServiceImp;
import com.mikael.web.service.Imp.Test02ServiceImp;
import com.mikael.web.service.Test02Service;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/r")
public class Test01Action {

    private final ApplicationContext applicationContext;

    private final Test02Service test02Service;



    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public String test01() {

        Test01ServiceImp test01ServiceImp = (Test01ServiceImp) applicationContext.getBean("Test01ServiceImp");
        System.out.println(test02Service.test01());
        System.out.println("1234132");
        String s = test01ServiceImp.test01();
        return s;
    }


    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    public Result test02() {

        Test02ServiceImp test01ServiceImp = (Test02ServiceImp) applicationContext.getBean("Test02ServiceImp");

        Result s = test01ServiceImp.test02();


        return s;
    }


}
