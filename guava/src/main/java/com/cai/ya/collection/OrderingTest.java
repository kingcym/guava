package com.cai.ya.collection;

import com.google.common.collect.Ordering;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/18 0:40
 */
public class OrderingTest {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 3, 2, 4,null);
        System.out.println(list);
        //将null放到第一个
        Collections.sort(list, Ordering.natural().nullsFirst());
        System.out.println(list);

        //Collections.sort(list, Ordering.natural().reverse().nullsFirst());
        System.out.println(list);
        System.out.println(Ordering.natural().nullsFirst().isOrdered(list));


    }
}
