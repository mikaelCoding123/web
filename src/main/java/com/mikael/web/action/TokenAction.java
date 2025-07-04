package com.mikael.web.action;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.mikael.web.bo.Admin;
import com.mikael.web.utils.exception.BizException;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.annotation.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author
 * @version 1.0
 * @date 2025/5/19
 */

@RestController
@RequestMapping("/token")
public class TokenAction {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getToken",method = RequestMethod.GET)
    public Result getToken(){

        Admin admin = new Admin();
        admin.setId(1234);
        admin.setName("明");
        admin.setPassword("qwer");
        HashMap<String, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("token", admin);
        String jwt = JWT.create().addPayloads(objectHashMap).setExpiresAt(new Date(System.currentTimeMillis() + 7 * 1000)).setKey("124".getBytes(StandardCharsets.UTF_8)).sign();
        String token = JWTUtil.createToken(objectHashMap, "124".getBytes(StandardCharsets.UTF_8));
        //校验token
        boolean verify = JWTUtil.verify(token,"124".getBytes(StandardCharsets.UTF_8) );
        boolean verify1 = JWT.create().parse(jwt).verify();

        return ResultUtil.success(verify);
    }


    @RequestMapping(value = "/advice",method = RequestMethod.GET)
    public Result getAdvice(){

        if(true){
            Set<HttpMethod> httpMethods = restTemplate.optionsForAllow("http://localhost:18092/asy/test02");


//            throw new BizException("advice=======");

        }

        System.out.println("=========");

        return ResultUtil.success();

    }


}
