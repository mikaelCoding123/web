package com.mikael.web.utils.mapstruct;

import java.util.concurrent.ThreadLocalRandom;

public class MapStructUtil {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int a = ThreadLocalRandom.current().nextInt(100);
            System.out.println(a);
        }


    }
}
