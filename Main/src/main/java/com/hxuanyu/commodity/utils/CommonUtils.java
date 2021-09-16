package com.hxuanyu.commodity.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * 通用工具类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class CommonUtils {
    /**
     * Used building output as Hex
     */
    private static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};


    public static Date getDateFromString(String dateString) {
        return getDateFromString(dateString, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 通过日期字符串获取日期对象
     *
     * @param dateString 日期格式
     * @param pattern    日期字符串
     * @return 日期对象
     */
    public static Date getDateFromString(String dateString, String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 对字符串进行MD5加密
     *
     * @param text 明文
     * @return 密文
     */
    public static String md5(String text) {
        MessageDigest msgDigest;

        try {
            msgDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "System doesn't support MD5 algorithm.");
        }

        try {
            //这个加密算法是按照GBK编码进行加密
            msgDigest.update(text.getBytes("GBK"));

        } catch (UnsupportedEncodingException e) {

            throw new IllegalStateException(
                    "System doesn't support your  EncodingException.");

        }

        byte[] bytes = msgDigest.digest();

        return new String(encodeHex(bytes));
    }

    public static char[] encodeHex(byte[] data) {

        int l = data.length;

        char[] out = new char[l << 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
            out[j++] = DIGITS[0x0F & data[i]];
        }

        return out;
    }
}
