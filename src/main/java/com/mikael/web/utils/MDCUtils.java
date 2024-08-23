package com.mikael.web.utils;

import cn.hutool.core.util.IdUtil;

public class MDCUtils {

    public static String  getTraceId() {
        String traceId = IdUtil.fastSimpleUUID().toUpperCase();
        return traceId;
    }
}
