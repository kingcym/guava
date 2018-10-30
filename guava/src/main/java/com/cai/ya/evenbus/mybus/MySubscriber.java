package com.cai.ya.evenbus.mybus;

import java.lang.reflect.Method;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/29 0:05
 */

public class MySubscriber {
    private final Object subscribe;
    private final Method method;

    private boolean disable =false;

    public MySubscriber(Object subscribe, Method method) {
        this.subscribe = subscribe;
        this.method = method;
    }

    public Object getSubscribe() {
        return subscribe;
    }

    public Method getMethod() {
        return method;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
}
