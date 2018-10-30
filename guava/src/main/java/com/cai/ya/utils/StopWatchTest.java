package com.cai.ya.utils;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/21 21:01
 */
public class StopWatchTest {
    public static void main(String[] args) throws InterruptedException {
        Stopwatch started = Stopwatch.createStarted();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(started.stop());

        Stopwatch reset = started.reset().start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(reset.stop());
    }
}
