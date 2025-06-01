package com.mikael.web.service.wxpay;

import com.mikael.web.utils.result.Result;

/**
 * @author
 * @version 1.0
 * @date 2025/5/20
 */

public class WxPayService  {
    private PayWay payWay;

    public Result WxPay(){
        System.out.println("wx支付");

        return null;
    }

    public void press(){
        payWay.onClick();
    }

}

class TestPayWay {
    public static void main(String[] args) {
        WxPayService wxPayService = new WxPayService();
        new WxPayService().press();
    }


}
