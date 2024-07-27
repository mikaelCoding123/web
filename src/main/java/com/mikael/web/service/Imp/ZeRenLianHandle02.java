package com.mikael.web.service.Imp;

import com.mikael.web.service.ZeRenLian;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(2)
public class ZeRenLianHandle02 implements ZeRenLian {

    @Override
    public int sort() {
        return 2;
    }

    @Override
    public void handle(String msg) {
            log.info("ZeRenLianHandle02 handle msg:{}",msg);

    }
}
