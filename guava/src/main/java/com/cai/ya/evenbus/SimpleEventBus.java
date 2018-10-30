package com.cai.ya.evenbus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/26 23:03
 */
public class SimpleEventBus {
    public static void main(String[] args) {
        //EventBus bus = new EventBus();
        //捕获异常
        EventBus bus = new EventBus(new SubscriberExceptionHandler() {
            @Override
            public void handleException(Throwable exception, SubscriberExceptionContext context) {
                System.out.println(exception.getMessage());
                context.getSubscriberMethod();
            }
        });
        bus.register(new SimpleListener()); //注册窃听器

        bus.post("1111");
    }
}
