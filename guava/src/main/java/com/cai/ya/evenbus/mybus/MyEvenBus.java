package com.cai.ya.evenbus.mybus;

import java.util.concurrent.Executor;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/28 22:15
 */
public class MyEvenBus implements Bus {
    private final MyRegistry registry = new MyRegistry();
    private final String name;
    private final MyDispatcher dispatcher;
    public MyEvenBus() {
        this("DEFAULT",null,MyDispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public MyEvenBus(String name) {
        this(name,null,MyDispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public MyEvenBus(String name, MyEvenExceptionHandle exceptionHandle, Executor executor) {
        this.name = name;
        this.dispatcher = MyDispatcher.newDispatcher(exceptionHandle,executor);
    }

    @Override
    public void register(Object subscribe) {
        this.registry.bind(subscribe);
    }

    @Override
    public void unregister(Object subscribe) {
        this.registry.unbind(subscribe);

    }

    @Override
    public void post(Object event) {
        this.post(event,"default");
    }

    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this,registry,event,topic);
    }

    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getName() {
        return null;
    }
}
