package com.mikael.web.utils.result;


import org.slf4j.MDC;

public class ResultUtil {


    public static Result put(Integer integer, String msg, Object o) {
        Result serviceResult = new Result();
        serviceResult.setCode(integer);
        serviceResult.setMsg(msg);
        serviceResult.setData(o);
        serviceResult.setTraceId(MDC.get("traceId"));
        return serviceResult;
    }

    public static Result error() {
        Result serviceResult = put(Integer.getInteger(CodeEnum.ERROR.getCode()), CodeEnum.ERROR.getMsg(), null);
        return serviceResult;
    }

    public static Result success() {
        Result serviceResult = put(Integer.getInteger(CodeEnum.SUCCESS200.getCode()), CodeEnum.SUCCESS.getMsg(), null);
        return serviceResult;
    }

    public static Result put(CodeEnum codeEnum, Object o) {
        Result serviceResult = put(Integer.getInteger(codeEnum.getCode()), codeEnum.getMsg(), o);
        return serviceResult;
    }

    public static void main(String[] args) {
        System.out.println(ResultUtil.error());
    }

}