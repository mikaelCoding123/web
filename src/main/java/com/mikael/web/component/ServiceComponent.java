package com.mikael.web.component;

import com.mikael.web.service.Test02Service;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;


/**
 * 来实现监听各个请求的信息
 */
@Component
@AllArgsConstructor
@Setter
public class ServiceComponent implements ApplicationListener<ServletRequestHandledEvent> {
    private Test02Service test02Service;

    @Override
    public void onApplicationEvent(ServletRequestHandledEvent event) {
        Throwable failureCause = event.getFailureCause();
        System.out.println(test02Service.test01()+"  foh");
        if (failureCause != null) {
            System.out.printf( "请求时发生的错误原因：%S",failureCause.getMessage());
        }
        System.err.printf(" 请求客户端地址: %S,请求URL: %S,请求Method：%S,请求耗时：%d Millis%n ",event.getClientAddress(),event.getRequestUrl(),event.getMethod(),event.getProcessingTimeMillis());
    }

    @Override
    public boolean supportsAsyncExecution() {
        return ApplicationListener.super.supportsAsyncExecution();
    }
}
