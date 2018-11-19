package com.cai.ya.collection;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/15 22:36
 */
public class ListTest {


    public static void main(String[] args) {
        //初始化
        LinkedList<Object> linkedList = Lists.newLinkedList();
        ArrayList<String> list2 = Lists.newArrayList();
        //处始化大小
        ArrayList<String> list3 = Lists.newArrayListWithCapacity(10);
        //处始化，并添加元素
        String[] ss = {"2"};
        List<String> list = Lists.asList("1", ss);
        ArrayList<String> list4 = Lists.newArrayList("A","B");




        //笛卡儿积
        List<List<String>> list5 = Lists.cartesianProduct(Lists.newArrayList("A","B"), Lists.newArrayList("1","2"));
        System.out.println(list5);//[[A, 1], [A, 2], [B, 1], [B, 2]]

        //元素转换
        List<String> transform = Lists.transform(Lists.newArrayList("A","B"), new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String input) {
                return input.toLowerCase();
            }
        });
        System.out.println(transform);//[a, b]

        //字符串转化为字符，返回ImmutableList，Immutable是不可变对象
        ImmutableList<Character> list6 = Lists.charactersOf("mnbvcxz");
        System.out.println(list6);//[m, n, b, v, c, x, z]

        //reversed
        List<Character> reverse = Lists.reverse(list6);
        System.out.println(reverse);//[z, x, c, v, b, n, m]

        //按个数分组
        List<List<Character>> partition = Lists.partition(reverse, 3);
        System.out.println(partition);//[[z, x, c], [v, b, n], [m]]
    }
}
