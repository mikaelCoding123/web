package com.mikael.web.schedule;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author
 * @version 1.0
 * @date 2025/5/11
 */

@Slf4j
@Component
public class ScheduleT {


//    @Scheduled(fixedDelay = 4000L)
    public void test01() {
        MDC.put("traceId", "Scheduled" + System.currentTimeMillis());
        log.info("......@Scheduled(fixedDelay = 4000L)");
    }
}
