package com.cai.ya.collection;

import com.cai.ya.cache.LRU.LinkedHashLRUcache;
import com.google.common.collect.*;

import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/17 0:28
 */
public class MultimapTest {
    public static void main(String[] args) {
        /**
         * LinkedListMultimap
         * <p>
         *  非线程安全
         * 可以存储相同key
         * get方法返回的是list
         * </p>
         * <p>
         *     线程安全使用：
         *     Multimap<Object, Object>  multimap= Multimaps.synchronizedMultimap(LinkedListMultimap.create());
         * </p>
         *
         *
         */
        LinkedListMultimap<Object, Object> multimap = LinkedListMultimap.create();


        multimap.put("1", "2");
        multimap.put("1", "2");
        multimap.put("1", "3");
        multimap.put("1", "4");
        System.out.println(multimap);//{1=[2, 2, 3, 4]}


        /**
         * HashMultimap
         * <p>
         * 非线程安全
         * 可以存储相同key
         * 相同key value覆盖
         * get方法返回的是set
         * </p>
         * <p>
         *     线程安全使用：
         *    Multimap<Object, Object>  hashMultimap= Multimaps.synchronizedMultimap(HashMultimap.create());
         * </p>
         */
        HashMultimap<Object, Object> hashMultimap = HashMultimap.create();
        hashMultimap.put("1", "2");
        hashMultimap.put("1", "2");
        hashMultimap.put("1", "3");
        hashMultimap.put("1", "4");
        System.out.println(hashMultimap);//{1=[4, 2, 3]}
    }
}
