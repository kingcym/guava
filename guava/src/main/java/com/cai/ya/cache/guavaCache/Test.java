package com.cai.ya.cache.guavaCache;

import com.google.common.cache.*;
import com.google.common.collect.ImmutableCollection;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/14 0:34
 */
public class Test {
    //CacheBuilder.newBuild().build

    public static void main(String[] args) {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(55)//设置最大个数
                .maximumWeight(1000) //设置重量，配合weigher使用
                .weigher(new Weigher<String, Object>() {
                    @Override
                    public int weigh(String key, Object value) {
                        return 100;
                    }
                })
                .initialCapacity(10)//初始化个数
                .expireAfterAccess(10, TimeUnit.SECONDS) //过期时间
                .expireAfterWrite(10, TimeUnit.SECONDS)  //过期时间
                .concurrencyLevel(1) //写的并发数
                .softValues()
                .weakKeys()
                .weakValues()
                .recordStats() //统计的
                .removalListener(new RemovalListener<String, Object>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, Object> notification) {
                        //RemovalCause cause = notification.getCause();
                        if (notification.wasEvicted()) { //被移除
                            System.out.println(notification.getKey() + notification.getValue());
                        }
                    }
                })
                .build(new CacheLoader<Object, Object>() {
                    @Override
                    public Object load(Object key) throws Exception {
                        return key.hashCode();
                    }
                });//创建数据源 todo 未设置数据源


        //注意  nullvalue
        //cache.putAll();可预加热
        //cache.get()
        //cache.getUnchecked()
        //cache.getIfPresent()


//        CacheStats stats = cache.stats(); //不可变对象
//
//        stats.hitCount();
//        stats.hitRate();
//        stats.missCount();
//        stats.missRate();
//
//        CacheBuilderSpec parse = CacheBuilderSpec.parse("");
//        CacheBuilder.from(parse).build();
    }
}
