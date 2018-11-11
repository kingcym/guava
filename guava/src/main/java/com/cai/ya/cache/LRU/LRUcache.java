package com.cai.ya.cache.LRU;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/11 18:57
 */
public interface LRUcache<k,v> {
    void put(k key,v value);
    v get(k key);
    void remove(k key);
    int size();
    void clear();
}
