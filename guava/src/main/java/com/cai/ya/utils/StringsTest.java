package com.cai.ya.utils;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/21 11:07
 */
public class StringsTest {

    public static void main(String[] args) {
        String s1 = Strings.emptyToNull("");
        System.out.println("空变null: " + s1);

        String s2 = Strings.nullToEmpty(null);
        System.out.println("null变空: " + s2);

        String s3 = Strings.commonPrefix("asc","ascvv");
        System.out.println("共同前缀: " + s3);


        String s4 = Strings.commonSuffix("asc11","ascvv11");
        System.out.println("共同后缀: " + s4);



        String s5 = Strings.repeat("asc11",3);
        System.out.println("原始字符复制3词: " + s5);

        boolean s6 = Strings.isNullOrEmpty("");
        System.out.println("判断是否为空或者null: " + s6);

        String s7 = Strings.padStart("abc", 4, 'f');
        System.out.println("长度不够，在前面补字符: " + s7);

        String s8 = Strings.padEnd("abc", 4, 'f');
        System.out.println("长度不够，在后面补字符: " + s8);

    }
}
