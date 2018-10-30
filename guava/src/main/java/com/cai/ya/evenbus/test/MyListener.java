package com.cai.ya.evenbus.test;

import com.cai.ya.evenbus.AbstractListener;
import com.cai.ya.evenbus.mybus.MySubscribe;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: Kingcym
 * @Description:     Listener可继承
 * @Date: 2018/10/26 22:55
 */
@Slf4j
public class MyListener{

    /**
     * 同步监听
     *
     * @param event
     */
    @MySubscribe
    public void lisrener1(String event) {
        log.info("1，监听到String信息：{}", event);
    }

    @MySubscribe(topic = "aa")
    public void lisrener2(String event) throws Exception {
        log.info("2，监听到String信息：{}",event);
    }



}
