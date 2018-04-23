package com.example.guava.utilites;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/2/27 16:52
 */
public class JoinerTest {
    private final static List<String> list = Arrays.asList("java","scala","c++","guava");
    private final static List<String> list2 = Arrays.asList("java","scala","c++",null);

    public static void main(String[] args) {
        String join1 = Joiner.on("#").join(list);
        //去掉对应null
        String join2 = Joiner.on("#").skipNulls().join(list2);
        //将null值替换
        String join3 = Joiner.on("#").useForNull("DEFFAULT").join(list2);

        System.out.println(join1);//java#scala#c++#guava
        System.out.println(join2);//java#scala#c++
        System.out.println(join3);//java#scala#c++#DEFFAULT
    }
}
