package com.mikael.web.component.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Aspect
public class Test02Aop {

    //获取自定义注解的值
    @Around("@annotation(com.mikael.web.component.aop.Test) && @annotation(test)")
    public Object around(ProceedingJoinPoint joinPoint, Test test) throws Throwable {
        // 在目标方法执行前执行的逻辑
        System.out.println("Before method execution");

        Object result = joinPoint.proceed(); // 执行目标方法

        // 在目标方法执行后执行的逻辑
        System.out.println("After method execution");
        log.info("Around method execution======" + test.value());
        return result;
    }


}





