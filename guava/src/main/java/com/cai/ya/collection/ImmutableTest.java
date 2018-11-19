package com.cai.ya.collection;

import com.google.common.collect.ImmutableList;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/18 0:23
 */
public class ImmutableTest {
    //不可变的collection
    public static void main(String[] args) {
        ImmutableList<Integer> of = ImmutableList.of(1, 2, 3);
        of.add(4);//抛异常
    }
}
