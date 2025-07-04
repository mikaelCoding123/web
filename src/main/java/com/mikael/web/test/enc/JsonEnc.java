package com.mikael.web.test.enc;


import cn.hutool.crypto.symmetric.DESede;
import com.mikael.web.bo.Admin;

public class JsonEnc {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.setId(134);
        admin.setName("admin");
        admin.setPassword("123456");
        //加密
        DESede deSede = new DESede();
        byte[] s = deSede.encrypt("123456");
        System.out.println(s);


    }

}
