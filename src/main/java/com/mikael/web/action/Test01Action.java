package com.mikael.web.action;


import com.mikael.web.bo.Admin;
import com.mikael.web.utils.result.CodeEnum;
import com.mikael.web.utils.result.Result;
import com.mikael.web.service.Imp.Test01ServiceImp;
import com.mikael.web.service.Imp.Test02ServiceImp;
import com.mikael.web.service.Test02Service;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/r")
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

    //post 请求
    @RequestMapping(value = "/postTest",method = RequestMethod.POST)
    public Result postTest(@Validated Admin admin) {
        log.info(admin.toString());
        return ResultUtil.success();
    }


    //遇到特殊字符的时候怎么处理
    @RequestMapping(value = "/test03", method = RequestMethod.GET)
    public Result test03(@PathParam("type") String type) {
        log.info("type==" + type);

        return ResultUtil.success();
    }

    //上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("file==" + file);
      if (file.isEmpty()) {
            return ResultUtil.put(CodeEnum.ERROR, "文件为空");
      }
        // 获取文件名
        file.transferTo(new File("Z:\\test\\ "+ UUID.randomUUID() + file.getOriginalFilename()));
        return ResultUtil.success();
    }





}
