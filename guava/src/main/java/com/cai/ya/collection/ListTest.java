package com.cai.ya.collection;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/15 22:36
 */
public class ListTest {


    public static void main(String[] args) {
        String[] ss = {"2"};
        List<String> list = Lists.asList("1", ss);
        System.out.println(list);
        ArrayList<String> list2 = Lists.newArrayList();
        //处始化大小
        ArrayList<String> list3 = Lists.newArrayListWithCapacity(10);

        ArrayList<String> list4 = Lists.newArrayList("A","B");
        System.out.println(list4);
        //笛卡儿积
        List<List<String>> list5 = Lists.cartesianProduct(list, list4);
        System.out.println(list5);

        List<String> transform = Lists.transform(list4, new Function<String, String>() {
            @Nullable
            @Override
            public String apply(@Nullable String input) {
                return input.toLowerCase();
            }
        });
        System.out.println(transform);

        ImmutableList<Character> list6 = Lists.charactersOf("mnbvcxz");
        System.out.println(list6);

        List<Character> reverse = Lists.reverse(list6);
        System.out.println(reverse);

        List<List<Character>> partition = Lists.partition(reverse, 3);
        System.out.println(partition);
    }
}
