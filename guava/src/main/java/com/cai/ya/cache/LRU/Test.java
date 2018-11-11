package com.cai.ya.cache.LRU;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/11 19:37
 */
public class Test {
    public static void main(String[] args) {
        LRUcache<String, String> cache = new LinkedHashLRUcache<>(3);
        cache.put("1","1");
        cache.put("2","2");
        cache.put("3","3");
        System.out.println(cache);//原始值
        cache.put("4","4");
        System.out.println(cache);//达到限制，删除最老的值
        cache.get("3");
        System.out.println(cache);//把最近使用值，放到最前面

    }
}
