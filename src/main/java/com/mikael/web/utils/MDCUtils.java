package com.mikael.web.utils;

import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MDCUtils {

    public static String getTraceId() {
        String traceId = IdUtil.fastSimpleUUID().toUpperCase();
        return traceId;
    }

    public static void main(String[] args) {
        String key = "@K2imC3$vH@vK2imC3$v6@vK2iC3$vHvK2imC3vH6@vKim3$vH6@";
        Map<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name", "mikael");
        stringStringHashMap.put("age", "18");
        stringStringHashMap.put("sex", "男");
        JWT jwt = JWT.create();
        jwt.setPayload("traceId", "12");
        jwt.setKey(key.getBytes(StandardCharsets.UTF_8)).setExpiresAt(new Date(System.currentTimeMillis() + 1000));
        String sign = jwt.sign();
        boolean t = JWT.of(sign).setKey(key.getBytes(StandardCharsets.UTF_8)).verify();
        JWTSigner hs256 = JWTSignerUtil.hs256(key.getBytes(StandardCharsets.UTF_8));
        String token = JWTUtil.createToken(stringStringHashMap, hs256);
        boolean verify = JWTUtil.verify(token, hs256);
        System.out.println(token);
        System.out.println(verify);
        System.out.println(sign);
        System.out.println(t);

        System.out.println(".".indexOf("/404.html"));

    }
}
