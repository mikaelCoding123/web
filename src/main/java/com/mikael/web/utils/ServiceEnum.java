package com.mikael.web.utils;

import com.mikael.web.service.EnumService;
import com.mikael.web.service.Imp.Enum01ServiceImp;
import com.mikael.web.service.Imp.Enum02ServiceImp;
import lombok.Getter;

@Getter
public enum ServiceEnum {

    TEST02("TEST02", new Enum02ServiceImp()),

    TEST01("TEST01", new Enum01ServiceImp());

    private final String serviceName;
    private final EnumService service;

    ServiceEnum(String serviceName, EnumService enumService) {
        this.serviceName = serviceName;
        this.service = enumService;
    }

}
