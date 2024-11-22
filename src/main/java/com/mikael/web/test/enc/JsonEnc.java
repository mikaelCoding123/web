package com.mikael.web.test.enc;


import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.DESede;
import com.mikael.web.bo.Admin;

import java.util.Base64;

public class JsonEnc {
    public static void main(String[] args) {
        Admin admin = new Admin();
        admin.setId(134);
        admin.setName("admin");
        admin.setPassword("123456");
        //加密
        DESede deSede = new DESede();



    }

}
