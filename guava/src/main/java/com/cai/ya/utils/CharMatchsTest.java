package com.cai.ya.utils;

import com.google.common.base.CharMatcher;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/21 12:32
 */
public class CharMatchsTest {

    public static void main(String[] args) {
        boolean matches = CharMatcher.javaDigit().matches('x');
        System.out.println(matches);

        int countIn = CharMatcher.is('a').countIn("aadca");
        System.out.println(countIn);

        String s1 = CharMatcher.javaDigit().or(CharMatcher.whitespace()).removeFrom("123 fff 1dd");
        System.out.println("移除数字与空格："+s1);

        String s2 = CharMatcher.javaDigit().or(CharMatcher.whitespace()).retainFrom("123 fff1dd");
        System.out.println("保留数字与空格："+s2);

    }


}
