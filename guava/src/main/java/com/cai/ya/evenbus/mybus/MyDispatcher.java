package com.cai.ya.evenbus.mybus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/28 23:24
 */
class MyDispatcher {
    private final Executor executorService;
    private final MyEvenExceptionHandle exceptionHandle;

    public final static Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    private final static Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;

    public MyDispatcher(Executor executorService, MyEvenExceptionHandle exceptionHandle) {
        this.executorService = executorService;
        this.exceptionHandle = exceptionHandle;
    }

    static MyDispatcher newDispatcher(MyEvenExceptionHandle evenExceptionHandle, Executor executor) {
        return new MyDispatcher(executor, evenExceptionHandle);
    }


    public void dispatch(Bus bus, MyRegistry registry, Object event, String topic) {
        ConcurrentLinkedQueue<MySubscriber> subscribers = registry.scanSubscriber(topic);
        if (subscribers == null) {
            if (exceptionHandle != null) {
                //todo
                exceptionHandle.handle(new IllegalArgumentException("topic无任何订阅：" + topic), null);
            }
        } else {
            subscribers.stream().filter(subscriber -> !subscriber.isDisable())
                    .filter(subscriber -> {
                        Method method = subscriber.getMethod();
                        Class<?> aClass = method.getParameterTypes()[0];
                        return aClass.isAssignableFrom(event.getClass());
                    }).forEach(subscriber -> {
                Object subscribe = subscriber.getSubscribe();
                Method method = subscriber.getMethod();
                try {
                    method.invoke(subscribe, event);
                } catch (Exception e) {
                    //todo
                    exceptionHandle.handle(e, null);
                }
            });
        }
    }


    public void close() {
        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    //串行处理（不启动线程处理）
    private static class SeqExecutorService implements Executor {
        private static SeqExecutorService INSTANCE = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    //启动线程处理
    private static class PreThreadExecutorService implements Executor {
        private static PreThreadExecutorService INSTANCE = new PreThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }
}
