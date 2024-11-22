package com.mikael.web.test;

import org.aspectj.weaver.ast.Var;

import java.util.concurrent.ThreadPoolExecutor;

public class Thread01 {

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("hello");
        },"01").run();
    }

}
