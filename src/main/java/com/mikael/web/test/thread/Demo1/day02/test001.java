package com.mikael.web.test.thread.Demo1.day02;

public class test001 {
    private final String name;

    public test001(String name) {
        this.name = name;
    }

    void m1() {
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        test001 t = new test001("zhangsan");
        new Thread(t::m1).start();

        new Thread(t::m1).start();
    }
}
