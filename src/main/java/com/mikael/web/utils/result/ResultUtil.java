package com.mikael.web.utils.result;


import jakarta.validation.constraints.NotNull;
import org.slf4j.MDC;

public class ResultUtil {

    public static Result put(Integer integer, String msg, Object o) {
        Result serviceResult = new Result();
        serviceResult.setCode(integer);
        serviceResult.setMsg(msg);
        serviceResult.setData(o);
//        if (MDC.get("traceId") == null) {
//            serviceResult.setTraceId("1234567890");
//        } else {
//            serviceResult.setTraceId(MDC.get("traceId"));
//        }
        return  MDC.get("traceId") == null ? serviceResult.setTraceId("1234567890") : serviceResult.setTraceId(MDC.get("traceId"));
    }

    public static Result error() {
        return put(Integer.getInteger(CodeEnum.ERROR.getCode()), CodeEnum.ERROR.getMsg(), null);
    }

    public static Result error(Object o) {
        return put(Integer.getInteger(CodeEnum.ERROR.getCode()), CodeEnum.ERROR.getMsg(), o);

    }

    public static Result success() {
        return put(Integer.getInteger(CodeEnum.SUCCESS200.getCode()), CodeEnum.SUCCESS.getMsg(), null);
    }

    public static Result success(@NotNull Object o) {
        return put(Integer.getInteger(CodeEnum.SUCCESS200.getCode()), CodeEnum.SUCCESS.getMsg(), o);
    }

    public static Result put(CodeEnum codeEnum, Object o) {
        return put(Integer.getInteger(codeEnum.getCode()), codeEnum.getMsg(), o);
    }

    public static void main(String[] args) {
        System.out.println(ResultUtil.error());
    }

}