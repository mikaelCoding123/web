package com.mikael.web.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanComponent implements BeanPostProcessor {


    private void beanPostProcess() {

        log.info("beanPostProcess++++++++++++++++");

    }


}
