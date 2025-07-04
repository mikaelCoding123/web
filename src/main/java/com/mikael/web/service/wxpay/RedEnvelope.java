package com.mikael.web.service.wxpay;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 分配红包
 */
public class RedEnvelope {

    /**
     * 分配微信红包
     *
     * @param totalMoney      总金额（单位：元）
     * @param totalPeople     总人数
     * @param minAmount       每人最小金额
     * @param maxAmount       每人最大金额
     * @param fluctuationRate 均值波动范围（如 0.2 表示 ±20%）
     * @return 每个人分得的金额列表
     */
    public static List<BigDecimal> divideRedEnvelope(BigDecimal totalMoney, int totalPeople, BigDecimal minAmount, BigDecimal maxAmount, BigDecimal fluctuationRate) {
        if (minAmount.multiply(BigDecimal.valueOf(totalPeople)).compareTo(totalMoney) > 0) {
            throw new IllegalArgumentException("最小金额乘以人数超过了总金额，无法分配");
        }
        if (maxAmount.multiply(BigDecimal.valueOf(totalPeople)).compareTo(totalMoney) < 0) {
            throw new IllegalArgumentException("最大金额乘以人数小于总金额，无法分配");
        }

        List<BigDecimal> result = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < totalPeople; i++) {
            int remainingPeople = totalPeople - i;

            // 动态调整分配范围
            BigDecimal mean = totalMoney.divide(BigDecimal.valueOf(remainingPeople), 2, RoundingMode.HALF_EVEN);
            BigDecimal lowerBound = mean.multiply(BigDecimal.ONE.subtract(fluctuationRate)).max(minAmount); // 最小值
            BigDecimal upperBound = mean.multiply(BigDecimal.ONE.add(fluctuationRate)).min(maxAmount);     // 最大值

            // 生成随机金额
            BigDecimal randomFactor = BigDecimal.valueOf(random.nextDouble());
            BigDecimal amount = lowerBound.add(randomFactor.multiply(upperBound.subtract(lowerBound)))
                    .setScale(2, RoundingMode.HALF_EVEN);

            //最后一位取余值，这样总金额一致
            if (i == totalPeople - 1) {
                amount = totalMoney;
            }
            result.add(amount);

            totalMoney = totalMoney.subtract(amount); // 更新剩余金额
        }

        return result;
    }

    public static void main(String[] args) {
        BigDecimal totalMoney = new BigDecimal("50.00"); // 总金额
        int totalPeople = 5;                             // 总人数
        BigDecimal minAmount = new BigDecimal("5.00");    // 每人最小金额
        BigDecimal maxAmount = new BigDecimal("20.00");   // 每人最大金额
        BigDecimal fluctuationRate = new BigDecimal("0.2"); // 均值波动范围 ±20%

        List<BigDecimal> amounts = divideRedEnvelope(totalMoney, totalPeople, minAmount, maxAmount, fluctuationRate);

        System.out.println("红包分配结果：");
        for (int i = 0; i < amounts.size(); i++) {
            System.out.printf("第 %d 个红包：%.2f 元\n", i + 1, amounts.get(i));
        }

        // 校验总金额是否正确
        BigDecimal sum = amounts.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.printf("分配的总金额：%.2f 元\n", sum);
    }
}
