package com.mikael.web.service.wxpay;

import cn.hutool.core.util.IdUtil;
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
     *todo 存在parts数组里存在为0和最后一位为0的情况
     * @param renshu 参与的人数
     * @param total   总的金额
     * @return
     */
    public BigDecimal[] hongbao(int renshu, double total) {

        BigDecimal[] parts = new BigDecimal[renshu];
        BigDecimal zeroBigDecimal = new BigDecimal("0");
        BigDecimal totalBigDecimal = new BigDecimal(total);
        BigDecimal remaining = BigDecimal.valueOf(0.01);//这次发的钱
        BigDecimal sum = BigDecimal.valueOf(0);//已经发的钱
        if(renshu==1){
            parts[0]=BigDecimal.valueOf(total);
            return parts;
        }
        for (int i = 0; i < renshu-1; i++) {//for循环是先做在判断
            BigDecimal random1 = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1)).multiply(BigDecimal.valueOf(total).subtract(sum)).setScale(2,RoundingMode.HALF_EVEN);
//            System.out.println("random1==="+random1);
            remaining = BigDecimal.valueOf(total).subtract(sum).subtract(random1);
            if (remaining.compareTo(zeroBigDecimal) == 0 || sum.compareTo(totalBigDecimal) == 0){
                i=i-1;
                continue;
            }
            parts[i] = remaining;
            sum = sum.add(remaining);
        }
//        System.out.println("total===="+total+"sum===="+sum);
        parts[renshu - 1] = BigDecimal.valueOf(total).subtract(sum);
        return parts;
    }

    public static void main(String[] args) {
        WxPayService wxPayService = new WxPayService();
        double t = 12.09 + 11.02;
        BigDecimal sum = BigDecimal.valueOf(0);

//        for (int i = 0; i < 100; i++) {
//            BigDecimal[] doubles = wxPayService.hongbao(6, 100);
//            for (BigDecimal aDouble : doubles) {
//                System.out.println("bao===="+aDouble);
//                sum = sum.add(aDouble);
//
//            }
//
//            System.out.println("sum===" + sum);
//            sum=BigDecimal.valueOf(0);
//        }


        System.out.println(IdUtil.getSnowflake().nextId()%11798123);



    }
}
