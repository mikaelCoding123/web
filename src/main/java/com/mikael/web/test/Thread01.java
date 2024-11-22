package com.mikael.web.test;

public class Thread01 {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("hello");
        },"01").run();



    }
}
