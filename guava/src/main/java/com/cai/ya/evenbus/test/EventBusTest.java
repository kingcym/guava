package com.cai.ya.evenbus.test;

import com.cai.ya.evenbus.SimpleListener;
import com.cai.ya.evenbus.mybus.MyEvenBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/26 23:03
 */
public class EventBusTest {
    public static void main(String[] args) {
        //EventBus bus = new EventBus();
        //捕获异常
        MyEvenBus bus = new MyEvenBus();
        bus.register(new MyListener()); //注册窃听器

        bus.post("1111","aa");
    }
}
