package com.cai.ya.cache.LRU;

import org.springframework.util.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Kingcym
 * @Description:  非线程安全
 * @Date: 2018/11/11 19:09
 */
public class LinkedHashLRUcache<k, v> implements LRUcache<k, v> {
    /**
     * LinkedHashMap（自身实现了ＬＲＵ算法）
     * 1.有序
     * 2.每次访问一个元素，都会提到最后面去
     */
    private static class InternalLRUcache<k, v> extends LinkedHashMap<k, v> {
        private final int limit;

        private InternalLRUcache(int limit) {
            super(16, 0.75f, true);
            this.limit = limit;
        }

        //是否删除最老的数据
        @Override
        protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
            return size() > limit;
        }
    }

    private final int limit;
    private final InternalLRUcache<k, v> internalLRUcache;


    public LinkedHashLRUcache(int limit) {
        Assert.state(limit > 0, "limit必须大于0");
        this.limit = limit;
        this.internalLRUcache = new InternalLRUcache(limit);
    }


    @Override
    public void put(k key, v value) {
        this.internalLRUcache.put(key, value);
    }

    @Override
    public v get(k key) {
        return this.internalLRUcache.get(key);
    }

    @Override
    public void remove(k key) {
        this.internalLRUcache.remove(key);
    }

    @Override
    public int size() {
        return this.internalLRUcache.size();
    }

    @Override
    public void clear() {
        this.internalLRUcache.clear();
    }

    @Override
    public String toString() {
        return internalLRUcache.toString();
    }
}
