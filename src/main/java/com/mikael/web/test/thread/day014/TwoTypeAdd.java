package com.mikael.web.test.thread.day014;

import java.math.BigDecimal;

/**
 * 两种不同类型的数相加
 */
public class TwoTypeAdd {
    public static void main(String[] args) {
        float m = 12.22F;
        float c = 1.22F;
        BigDecimal b1 = new BigDecimal(Float.toString(m));
        BigDecimal b2 = new BigDecimal(Float.toString(c));
        System.out.println(b1.add(b2));
        /** 以上方法可以解决float类型的值加法精度问题* */
        TwoTypeAdd twoTypeAdd = new TwoTypeAdd();
        System.out.println(twoTypeAdd.add(1L, 45));
    }

    public <T extends Number> double add(T t1, T t2) {
        double sum;
        sum = t1.doubleValue() + t2.doubleValue();
        return sum;
    }
}
