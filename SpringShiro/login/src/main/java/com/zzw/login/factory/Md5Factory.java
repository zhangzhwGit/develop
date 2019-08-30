package com.zzw.login.factory;

import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @name Md5Factory
 * @description
 * @date 2019-08-29
 */
public class Md5Factory {

    public static Md5Hash getMd5Hash(String password, String salt, int saltNum) {
        return new Md5Hash(password, salt, saltNum);
    }

    public static String defaultMd5HashStr(String salt) {
        return new Md5Hash("123456", salt, 2).toString();
    }

    public static String getMd5HashStr(String password, String salt, int saltNum) {
        return new Md5Hash(password, salt, saltNum).toString();
    }

    public static UsernamePasswordToken getToken(String username, String password) {
        return new UsernamePasswordToken(username, password.toCharArray());
    }
}
