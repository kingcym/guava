package com.cai.ya.cache.reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Kingcym
 * @Description:  强引用
 *
 * 设置堆最大内存128M，超出将OutOfMemoryError
 * @Date: 2018/11/12 0:01
 */
public class StrongReference {

    public static void main(String[] args) {
        int i =0;
        List<Ref> list = new ArrayList<>();
        for (;;){
            int i1 = i++;
            Ref ref = new Ref(i1);
            list.add(ref);
            System.out.println(i1 + "加到list中");
        }

    }

    private static class Ref{
        private byte[] bytes = new byte[1024*1024];//1M
        private final int index;

        private Ref(int index) {
            this.index = index;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("--index---" + index + "---将要GC");
        }
    }
}
