package com.mikael.web.test.Jdk8Features;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author：Mikael
 */
public class GroupingUser {
    public static void main(String[] args) {
        List<User> objects =
                Arrays.asList(
                        new User(12, "hua", 17),
                        new User(22, "li2", 17),
                        new User(22, "zhao1", 17),
                        new User(12, "zhao1", 64));
        // 根据User的Age分组,然后以age为map的key返回
        Map<Integer, List<User>> collect =
                objects.stream().collect(Collectors.groupingBy(User::getAge));
        // 看看collect 跟collect2 中map的区别
        Map<String, List<User>> collect2 =
                objects.stream().collect(Collectors.groupingBy(User::getName));
        System.out.println(collect.get(64));
        System.out.println(collect);
        System.out.println("===============");
        System.out.println(collect2);
        // 字符串中区分数字跟字符
        String str = "jfksjf763jfl";
        char[] chars = str.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (char aChar : chars) {
            if (aChar < 'a') {
                stringBuffer.append(aChar);
            } else {
                stringBuffer2.append(aChar);
            }
        }
        System.out.println(stringBuffer);
        System.out.println(stringBuffer2);
        BigInteger bigInteger = new BigInteger("22");
        BigInteger multiply = bigInteger.multiply(new BigInteger("12"));
        System.out.println(multiply);
        BigDecimal a2 = new BigDecimal("0.22");
        BigDecimal b2 = new BigDecimal("0.55");
        BigDecimal multiply1 = a2.multiply(b2);
        System.out.println(multiply1);
    }
}
