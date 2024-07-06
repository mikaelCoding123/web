package com.mikael.web.action;


import com.mikael.web.service.Test01Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/r")
public class Test01Action {

    private final Test01Service test01Service;


    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public String test01(){
        String s = test01Service.test01();
        return s;
    }



}
