package com.mikael.web.action;


import com.mikael.web.bo.Admin;
import com.mikael.web.utils.result.CodeEnum;
import com.mikael.web.utils.result.ServiceResult;
import com.mikael.web.service.Imp.Test01ServiceImp;
import com.mikael.web.service.Imp.Test02ServiceImp;
import com.mikael.web.service.Test02Service;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/test01")
public class Test01Action {

    private final ApplicationContext applicationContext;

    private final Test02Service test02Service;
    private final RestTemplate restTemplate;

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    public String test01() {

        Test01ServiceImp test01ServiceImp = (Test01ServiceImp) applicationContext.getBean("Test01ServiceImp");
        System.out.println(test02Service.test01());
        System.out.println("1234132");
        String s = test01ServiceImp.test01();
        return s;
    }


    @RequestMapping(value = "/test02", method = RequestMethod.GET)
    public ServiceResult test02() {
        Test02ServiceImp test01ServiceImp = (Test02ServiceImp) applicationContext.getBean("Test02ServiceImp");
        ServiceResult s = test01ServiceImp.test02();
        return s;
    }

    //post 请求
    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public ServiceResult postTest(@Validated Admin admin) {
        Optional.ofNullable(admin).orElseThrow(() -> new RuntimeException("admin is null"));
        log.info(admin.toString());
        return ResultUtil.success();
    }


    //遇到特殊字符的时候怎么处理
    @RequestMapping(value = "/test03", method = RequestMethod.GET)
    public ServiceResult test03(@PathParam("type") String type) {
        log.info("type==" + type);

        return ResultUtil.success();
    }

    //上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ServiceResult upload(@RequestParam("file") MultipartFile file) throws IOException {
        log.info("file==" + file);
        if (file.isEmpty()) {
            return ResultUtil.put(CodeEnum.ERROR, "文件为空");
        }

        // 获取文件名
        file.transferTo(new File("Z:\\test\\ " + UUID.randomUUID() + file.getOriginalFilename()));
        return ResultUtil.success();
    }


    //
    @RequestMapping(value = "/test04", method = RequestMethod.GET)
    public ResponseEntity test04() {
        ResponseEntity.status(HttpStatus.BAD_GATEWAY);
        return ResponseEntity.ok("");



    }

    //远程调用
    @RequestMapping(value = "/test05", method = RequestMethod.GET)
    public ServiceResult test05() {
        log.info("-----------------"+ MDC.get("traceId"));
        ResponseEntity<ResponseEntity> forEntity = restTemplate.getForEntity("http://localhost:8090/test01/test04", ResponseEntity.class);
        return ResultUtil.success(forEntity);
    }

}
