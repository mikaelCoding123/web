package com.mikael.web.service.wxpay;

import com.mikael.web.bo.Order;
import com.mikael.web.service.PayWayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author
 * @version 1.0
 * @date 2025/5/20
 */

@Service("WxPayService")
@Slf4j
public class WxPayService extends PayFilterService implements PayWayService {

    @Override
    public void chosePayWay(Order order) {
        log.info(".....chosePayWay......");
    }

    /**
     *
     * @param renshu 参与的人数
     * @param total   总的金额
     * @return
     */
    public BigDecimal[] hongbao(int renshu, double total) {
        BigDecimal[] parts = new BigDecimal[renshu];
        BigDecimal remaining = BigDecimal.valueOf(0.01);//这次发的钱
        BigDecimal sum = BigDecimal.valueOf(0);//已经发的钱
        for (int i = 0; i < renshu-1; i++) {//for循环是先做在判断
            if(renshu==1){
                parts[0]=BigDecimal.valueOf(total);
                return parts;
            }
            BigDecimal random1 = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1)).multiply(BigDecimal.valueOf(total).subtract(sum)).setScale(2,RoundingMode.HALF_EVEN);
            System.out.println("random1==="+random1);
            remaining = BigDecimal.valueOf(total).subtract(sum).subtract(random1);
            parts[i] = remaining;
            sum = sum.add(remaining);
        }
        System.out.println("total===="+total+"sum===="+sum);
        parts[renshu - 1] = BigDecimal.valueOf(total).subtract(sum);

        return parts;
    }

    public static void main(String[] args) {
        WxPayService wxPayService = new WxPayService();
        BigDecimal sum = BigDecimal.valueOf(0);

        for (int i = 0; i < 100; i++) {
            BigDecimal[] doubles = wxPayService.hongbao(6, 100);
            for (BigDecimal aDouble : doubles) {
                System.out.println(aDouble);
                sum = sum.add(aDouble);

            }

            System.out.println("sum===" + sum);
            sum=BigDecimal.valueOf(0);
        }


    }

}
