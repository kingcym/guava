package com.cai.ya.evenbus.mybus;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: Kingcym
 * @Description: 注册表
 * @Date: 2018/10/28 22:16
 */
class MyRegistry {//包可见
    private final ConcurrentHashMap<String,ConcurrentLinkedQueue<MySubscriber>>
    map = new ConcurrentHashMap<>();


    public void bind(Object subscribe) {
       List<Method> methods = getsubscribeMethods(subscribe);
        for (Method method : methods) {
            MySubscribe annotation = method.getDeclaredAnnotation(MySubscribe.class);
            String topic = annotation.topic();
            ConcurrentLinkedQueue<MySubscriber> mySubscribers = map.get(topic);
            if (mySubscribers == null){
                mySubscribers =new ConcurrentLinkedQueue<>();
                map.put(topic,mySubscribers);
            }
            mySubscribers.add(new MySubscriber(subscribe,method));
        }
    }


    //删除影响效率，添加一个标识
    public void unbind(Object subscribe) {
        map.forEach((key,queue)->{
            queue.forEach(s->{
                if (s.getSubscribe() == subscribe){
                    s.setDisable(true);
                }
            });
        });
    }

    public ConcurrentLinkedQueue<MySubscriber> scanSubscriber(String topic){
        return map.get(topic);
    }


    private List<Method> getsubscribeMethods(Object subscribe) {
        ArrayList<Method> list = new ArrayList<>();
        Class<?> temp = subscribe.getClass();
        while (temp != null){
            //获取自身所有方法（与访问权限无关，不包括继承）
            Method[] methods = temp.getDeclaredMethods();
            Arrays.stream(methods)
                    //过滤，方法被注解修饰，参数只有一个，权限是public
                    .filter(m->m.isAnnotationPresent(MySubscribe.class)
                            && m.getParameterCount()==1&&m.getModifiers()== Modifier.PUBLIC)
                    .forEach(list::add);
            temp = temp.getSuperclass();
        }
        return list;
    }

}
