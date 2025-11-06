package com.mikael.web.utils.result;

/**
 * encoded: UTF-8 写法必须按照javadoc的格式写清楚msg的内容
 * <p>
 * 接口返回枚举定义
 * 只增加不删除不修改
 * <p>
 * //200	OK:请求
 * //400	Bad Request：客户端请求的语法错误，服务器无法理解
 * //500	Internal Server Error：内部服务器错误
 * //json 中的code值
 * //200	结果正常
 * //300	参数错误
 * //520	后端服务请求失败
 * //530	服务繁忙（超时）
 */
public enum CodeEnum {
    /**
     * 000000 操作成功
     */
    SUCCESS(200, "操作成功", false),
    /**
     * 999999 操作失败
     */
    ERROR(999999, "操作失败", false),
//    /**
//     * 999999 msg1
//     */
//    ERROR_100("999999", "MSG1", false),
//
//    /**
//     * 9999999 异常
//     */
//    Exception("9999999", "异常", false),
//    /**
//     * 9999999 "不能直接返回String类型，需要包装成ServiceResult类型返回"
//     */
//    Exception_100("9999999", "不能直接返回String类型，需要包装成ServiceResult类型返回", false),
//
//    /*****参数错误：10001-19999***********************************************************/
//    PARAM_IS_INVALID("10001", "参数无效", false),
//    /***********用户错误：20001-29999****************************************************/
//    USER_NOT_LOGGED_IN("20001", "用户未登录，请登录", false),
//    USER_LOGIN_ERROR("20002", "账号不存在或者密码错误", false),
//    USER_ACCOUNT_FORBIDDEN("20003", "账号已被禁用", false),
//    USER_NOT_EXIST("20004", "用户不存在", false),
//    USER_HAS_EXISTED("20005", "用户已存在", false),
//    /*************第三方接口请求：30001-39999******************************************************/
//    THIRD_TOKEN_GET_FAILED("30001", "token获取失败", false),
//    THIRD_TOKEN_INVALID("30002", "token失效", false),
//    /**********************:40001-49999*************************************************/
//
//    /**********************:50001-59999*************************************************/
//
//    /**********************99999*************************************************/
//    ERROR_CONTACT_CUSTOMER_SERVICE("99999", "系统维护中。。。。。", false),
//    RC91000("91000", "91000错误", false),

    /**
     * 操作成功
     */
    SUCCESS200(200, "操作成功", false),
//    /**
//     * 操作失败
//     */
//    ERROR400("400", "操作失败", false),
//    /**
//     * 未经过身份认证
//     */
//    AUTH_ERROR("401", "未经过身份认证", false),
//    /**
//     * token参数不存在,无访问权限
//     */
//    NO_TOKEN("40101", "token参数不存在,无访问权限", false),
//    /**
//     * token验证失败,无访问权限
//     */
//    CHECK_TOKEN("40102", "token验证失败,无访问权限", false),
//    /**
//     * accessKeyId参数不存在
//     */
//    NO_SECRET_ID("40151", "accessKeyId参数不存在", false),
//    /**
//     * sign签名参数不存在
//     */
//    NO_SECRET_SIGN("40152", "sign签名参数不存在", false),
//    /**
//     * 请求校验失败
//     */
//    CHECK_SECRET("40153", "请求校验失败", false),
    /**
     * 资源不存在
     */
    NOT_FOUND(404, "资源不存在", false),
    /**
     * 服务器异常,请稍后再试
     */
    SYSTEM_ERROR(500, "服务器异常,请稍后再试", false),
    /**
     * 用户信息解析异常,请稍后再试
     */
    USERPRINCIPAL_RESOLVER_ERROR(50001, "用户信息解析异常,请稍后再试", false),
    /**
     * RPC或其他项目通信调用异常，外部服务异常
     */
    RPC_ERROR(503, "外部服务异常", false),


    ;


    private Integer code;
    private String msg;
    private boolean flag;

    CodeEnum(Integer code, String msg, boolean flag) {
        this.code = code;
        this.msg = msg;
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}