package com.mikael.web.service.Imp;

import com.mikael.web.service.EnumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("Enum02ServiceImp")
public class Enum02ServiceImp implements EnumService {

    @Override
    public void sayHello(String string) {
        log.info("Enum02ServiceImp==================" + string);

    }

}
