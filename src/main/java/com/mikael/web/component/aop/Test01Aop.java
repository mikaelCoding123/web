package com.mikael.web.component.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Test01Aop {

    // 定义切点（拦截的规则）
    @Pointcut("execution(* com.mikael.web.action.*(..))")
    public void pointcut() {
    }

    // 前置通知
    @Before("pointcut()")
    public void doBefore() {
        System.out.println("执行了前置通知");
    }

    // 后置通知
    @After("pointcut()")
    public void doAfter() {
        // 后置通知实现的具体业务代码
        System.out.println("执行了后置通知");
    }

    // 环绕通知
    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Object result = null;
        // 前置业务代码
        System.out.println("环绕通知的前置执行方法");
        try {
            // 执行目标方法
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 后置业务执行代码
        System.out.println("环绕通知的后置执行方法");
        return result;
    }
}
