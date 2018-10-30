package com.cai.ya.utils;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.Map;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/20 23:29
 */
public class SplitterTest {

    public static void main(String[] args) {
        List<String> list = Splitter.on("#").splitToList("1#2#3#4");
        System.out.println(list);

        List<String> list1 = Splitter.on("#").limit(2).splitToList("1#2#3#4");
        System.out.println(list1);

        List<String> list2 = Splitter.on("#").omitEmptyStrings().splitToList("1#2#3#4###");
        System.out.println(list2);


        List<String> list3 = Splitter.on("#").trimResults().omitEmptyStrings().splitToList("1# 2#3 #4###");
        System.out.println(list3);

        List<String> list4 = Splitter.fixedLength(2).splitToList("1234");
        System.out.println(list4);


        Map<String, String> map = Splitter.on("#").withKeyValueSeparator("=").split("1=1#2=2#3=3#4=4");
        System.out.println(map);
    }
}
