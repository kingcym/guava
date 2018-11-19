package com.cai.ya.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/16 23:40
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet<Integer> set = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> set1 = Sets.newHashSet(Lists.newArrayList(1, 1, 2, 3, 4));

        //子集，size表示每一个子集的个数
        Set<Set<Integer>> set2 = Sets.combinations(Sets.newHashSet(1, 2, 3), 2);
        set2.forEach(System.out::print);//[1, 2][1, 3][2, 3]
        //差集，交集，并集


    }
}
