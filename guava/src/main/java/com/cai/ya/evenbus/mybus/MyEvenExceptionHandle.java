package com.cai.ya.evenbus.mybus;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/28 22:29
 */
public interface MyEvenExceptionHandle {
    void handle(Throwable throwable,MyEvenContext context);
}
