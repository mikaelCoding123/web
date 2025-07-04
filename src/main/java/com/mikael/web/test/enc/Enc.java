package com.mikael.web.test.enc;

import cn.hutool.crypto.SecureUtil;

import java.util.UUID;

/**
 * @author
 * @version 1.0
 * @date 2025/6/1
 */
//用hutool进行加密解密
public class Enc {
    public static void main(String[] args) {
        System.out.println(enc("123456"));
        boolean comparison = comparison("123456", "3383c00b44b1#43234585dfba0341a7dd9ccb89ef3d5dedcb0190a1fbc42c26beaa3c845f71b9");
        System.out.println(comparison);

    }

    //进行加密存入数据库
    public static String enc(String password) {
        String salt = UUID.randomUUID().toString().split("-")[4];
        String sha256 = SecureUtil.sha256(password + salt);
        return salt + "#" + sha256;
    }

    /**
     * 密码核对
     *
     * @param password1 输入的密码
     * @param password2 数据库的密码
     * @return boolean
     */
    public static boolean comparison(String password1, String password2) {
        String[] salt = password2.split("#");
        return password2.equals(salt[0] + "#" + SecureUtil.sha256(password1.trim() + salt[0]));
    }
}
