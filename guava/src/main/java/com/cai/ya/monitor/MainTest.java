package com.cai.ya.monitor;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/28 16:18
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        DirectoryTargetMonitor monitor = new
                DirectoryTargetMonitor("E:\\images\\images\\ss");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    monitor.stopMonitor();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        monitor.startMonitor();

    }
}
