package com.cai.ya.utils;

import com.google.common.base.Preconditions;

import java.util.List;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/10/21 0:11
 */
public class PreconditionsTest {
    public static void main(String[] args) {
        List list = null;
      //  Preconditions.checkNotNull(list,"不能为空");
        Preconditions.checkArgument("A".equals("B"),"ggg");
    }
}
