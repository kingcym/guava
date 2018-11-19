package com.cai.ya.collection;

import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/17 1:10
 */
public class BiMapTest {
    public static void main(String[] args) {
        /**
         * 非线程安全
         * 不能存在相同key,也不能存在相同value
         *
         * 线程安全使用： Maps.synchronizedBiMap(biMap)
         */
        //相同key覆盖，相同value抛错
        HashBiMap<Object, Object> biMap = HashBiMap.create();
        biMap.put("11","2");
        biMap.put("1","3");
        System.out.println(biMap);//{11=2, 1=3}
        try {
            biMap.put("2","3");
        } catch (Exception e) {
            e.printStackTrace();//java.lang.IllegalArgumentException: value already present: 3
        }
        //强行加元素，若value和之前的相同，则覆盖之前的entry
        biMap.forcePut("3","3");
        System.out.println(biMap);//{11=2, 3=3}
    }
}
