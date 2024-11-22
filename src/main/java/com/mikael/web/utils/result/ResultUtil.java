package com.mikael.web.utils.result;


import jakarta.validation.constraints.NotNull;
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
        return put(Integer.getInteger(CodeEnum.ERROR.getCode()), CodeEnum.ERROR.getMsg(), null);
    }
    public static Result error(Object e) {
        return put(Integer.getInteger(CodeEnum.ERROR.getCode()), CodeEnum.ERROR.getMsg(), e);

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