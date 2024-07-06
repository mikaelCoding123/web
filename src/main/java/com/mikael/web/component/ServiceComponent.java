package com.mikael.web.component;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;


/**
 * 来实现监听各个请求的信息
 */
@Component
public class ServiceComponent implements ApplicationListener<ServletRequestHandledEvent> {
    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        Throwable failureCause = event.getFailureCause();
        if (failureCause != null) {
            System.out.printf( "请求时发生的错误原因：%S",failureCause.getMessage());
        }
        System.err.printf(" 请求客户端地址: %S,请求URL: %S,请求Method：%S,请求耗时：%d%n",event.getClientAddress(),event.getRequestUrl(),event.getMethod(),event.getProcessingTimeMillis());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
