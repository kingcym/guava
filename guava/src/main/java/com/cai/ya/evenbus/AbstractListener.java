package com.cai.ya.evenbus;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/26 22:55
 */
@Slf4j
public abstract class AbstractListener {

    /**
     * 同步监听
     *
     * @param event
     */
    @Subscribe
    public void abstractListener(String event) {
        log.info("AbstractListener监听到String信息：{}", event);
    }





}
