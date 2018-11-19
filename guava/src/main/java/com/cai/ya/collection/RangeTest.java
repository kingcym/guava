package com.cai.ya.collection;

import com.google.common.collect.Maps;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/17 22:07
 */
public class RangeTest {
    public static void main(String[] args) {
        //[]
        Range<Integer> closed = Range.closed(1, 5);
        //()
        Range<Integer> open = Range.open(1, 5);
        //(]
        Range<Integer> openClosed = Range.openClosed(1, 5);
        //[)
        Range<Integer> closedOpen = Range.closedOpen(1, 5);

        TreeMap<Integer, String> treeMap = Maps.newTreeMap();
        treeMap.put(1,"111");
        treeMap.put(3,"333");
        treeMap.put(2,"222");
        treeMap.put(4,"444");
        System.out.println(treeMap);//{1=111, 2=222, 3=333, 4=444}

        NavigableMap<Integer, String> subMap = Maps.subMap(treeMap, Range.closed(1, 3));
        System.out.println(subMap);//{1=111, 2=222, 3=333}


        TreeRangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(90,100),"A");
        rangeMap.put(Range.closed(60,89),"B");
        System.out.println(rangeMap);//[[60..89]=B, [90..100]=A]
        System.out.println(rangeMap.get(99));//A
    }
}
