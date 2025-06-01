package com.mikael.web.service.wxpay;

public interface PayWay {
    default void payWay() {
        System.out.println("interface PayWay");
    }

    void onClick();

}
