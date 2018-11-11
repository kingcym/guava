package com.cai.ya.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/4 23:46
 */
public class RateLimitTest {
    private static final RateLimiter LIMITER = RateLimiter.create(1);

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println(LIMITER.acquire(5));
        }
    }
}
