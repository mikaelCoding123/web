package com.mikael.web.service.Imp;

import com.mikael.web.service.ZeRenLian;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(1)
public class ZeRenLianHandle01 implements ZeRenLian {

    @Override
    public int sort() {
        return 1;
    }

    @Override
    public void handle(String msg) {
        log.info("ZeRenLianHandle01 handle msg:{}", msg);

    }
}
