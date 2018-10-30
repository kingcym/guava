package com.cai.ya.evenbus;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Kingcym
 * @Description:     Listener可继承
 * @Date: 2018/10/26 22:55
 */
@Slf4j
public class SimpleListener extends AbstractListener{

    /**
     * 同步监听
     *
     * @param event
     */
    @Subscribe
    public void lisrener1(String event) {
        log.info("1，监听到String信息：{}", event);
    }

    @Subscribe
    public void lisrener2(String event) throws Exception {
        log.info("2，监听到String信息：{}",event);
        throw new Exception("11");
    }



    public void lisrener3(Integer event){
        log.info("3，监听到Integer信息：{}",event);
    }
}
