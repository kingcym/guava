package com.cai.ya.evenbus.mybus;

/**
 * @Author: Kingcym
 * @Description: 仿照guava自定义一个 evenbus
 * @Date: 2018/10/28 22:10
 */
public interface Bus {
    void register(Object subscribe);
    void unregister(Object subscribe);
    void post(Object event);
    void post(Object event,String topic);
    void close();
    String getName();
}
