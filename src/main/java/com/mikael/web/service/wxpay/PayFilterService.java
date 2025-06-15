package com.mikael.web.service.wxpay;

import com.mikael.web.bo.Order;

/**
 * @author
 * @version 1.0
 * @date 2025/6/15
 */

public abstract class PayFilterService {
    public boolean filter(Order order) {
        System.out.println(".....PayFilterService......");
        if (!order.getOrder_status().equals("2")) {
            return false;
        }

        return true;
    }

}
