package com.mikael.web.utils;


/**
 * 统一文字说明管理
 */
public enum WordEnum {
    WORLD_NOT_FOUND("请查看正确的地址"),
    woi("")



        ;
    private String message;

    WordEnum(String message) {
        this.message = message;
    }
}
