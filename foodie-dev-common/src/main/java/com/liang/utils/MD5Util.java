package com.liang.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/26 22:23
 * @content md5加密工具
 */
public class MD5Util {

    public static String getMD5Str(String str) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Base64.encodeBase64String(md5.digest(str.getBytes()));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getMD5Str("liangyehao"));
    }
}
