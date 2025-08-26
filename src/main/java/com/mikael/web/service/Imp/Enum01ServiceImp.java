package com.mikael.web.service.Imp;


import com.mikael.web.service.EnumService;
import jakarta.annotation.Priority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("Enum01ServiceImp")
//@Priority(1)
public class Enum01ServiceImp implements EnumService {


    @Override
    public void sayHello(String string) {
        log.info("Enum01ServiceImp=================="+string);

    }
}
