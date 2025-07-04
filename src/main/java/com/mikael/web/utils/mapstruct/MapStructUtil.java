package com.mikael.web.utils.mapstruct;

import cn.hutool.core.lang.Snowflake;

import java.util.concurrent.ThreadLocalRandom;

public class MapStructUtil {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int a = ThreadLocalRandom.current().nextInt(100);
            System.out.println(a);
        }
        Snowflake snowflake = new Snowflake();
        System.out.println(snowflake.nextIdStr());
        System.out.println(Long.MAX_VALUE);


    }
}
