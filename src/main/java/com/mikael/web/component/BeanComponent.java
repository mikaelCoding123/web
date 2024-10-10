package com.mikael.web.component;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * order注解这里没用不知道是不是用法不对
 */
@Component
@Slf4j
public class BeanComponent {

    /**
     * bean完成之后立即执行
     */
    @PostConstruct
    @Order(2)
    private void beanPostProcess() {
        log.info("beanPostProcess++++++++++++++++order(2)");

    }

    @PostConstruct
    @Order(1)
    private void beanPostProcess2() {
        log.info("beanPostProcess++++++++++++++++order(1)");

    }

    @PostConstruct
    @Order(3)
    private void beanPostProcess3() {
        log.info("beanPostProcess++++++++++++++++order(3)");

    }

}
