package com.mikael.web.utils;

public class Track01 extends AbstractTrack {
    public void test(){
        System.out.println("test");
    }


    public static void main(String[] args) {
        new Track01().test();
        String code = ""+"13065987655".hashCode();
        System.out.println(2*System.currentTimeMillis()+13065987655l);

    }
}

