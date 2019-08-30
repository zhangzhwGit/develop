package com.zzw.login.mbgutil;

import com.zzw.login.factory.Md5Factory;

/**
 * @name Md5Test
 * @description
 * @date 2019-08-29
 */
public class Md5Test {

    public static void main(String[] args) {
        String pwd1 = Md5Factory.getMd5HashStr("123456", "00001zzw", 3);
        System.out.println(pwd1);
        String pwd2 = Md5Factory.getMd5HashStr("123456", "00002yc", 5);
        System.out.println(pwd2);
    }
}
