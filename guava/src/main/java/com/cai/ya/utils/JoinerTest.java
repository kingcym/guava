package com.cai.ya.utils;

import com.google.common.base.Joiner;

import java.util.*;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/20 21:25
 */
public class JoinerTest {
    private static List<String> notNullList = Arrays.asList("php", "c++", "java", "scala");
    private static List<String> nullList = Arrays.asList("php", null, "java", "scala");
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("1","java");
        map.put("2","php");
    }

    public static void main(String[] args) {
        /***/
        String join1 = Joiner.on("#").join(notNullList);
        System.out.println("以#号分割的字符串------------：" + join1);
        /***/
        String join2 = Joiner.on("#").skipNulls().join(nullList);
        System.out.println("排查null,以#号分割的字符串----：" + join2);
        /***/
        String join3 = Joiner.on("#").useForNull("替换null").join(nullList);
        System.out.println("替换null,以#号分割的字符串----：" + join3);
        /***/
        StringBuilder builder = new StringBuilder();
        StringBuilder StringBuilder = Joiner.on("#").useForNull("替换null").appendTo(builder, nullList);
        System.out.println(builder == StringBuilder);//同一个实例
        System.out.println("替换null,以#号分割的字符串，并放到另一个容器----："+ builder);


        String join4 = Joiner.on("#").withKeyValueSeparator("=").join(map);

        System.out.println("以#号分割的字符串，键值对替换----："+ join4);

    }

}
