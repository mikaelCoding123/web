package com.mikael.web.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author
 * @version 1.0
 * @date 2025/6/15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private final static long serialVersionUID = 1L;
    private String orderId;
    private String goods_name;
    private int numbers;
    private Double price;//单价
    private Double total_price;//总价
    private String order_status;
    private Date create_time;//创建时间
    private Date update_time;//修改时间
    private String pay_way;//支付方式

}
