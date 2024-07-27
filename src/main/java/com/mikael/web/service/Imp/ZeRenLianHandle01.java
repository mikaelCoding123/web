package com.mikael.web.service.Imp;

import com.mikael.web.service.ZeRenLian;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
            log.info("ZeRenLianHandle01 handle msg:{}",msg);

    }
}
