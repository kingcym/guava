package com.cai.ya.cache.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *WeakReference（弱引用）:
 * 当发生GC(MinorGC/FullGC)时，都会被回收掉。
 */
public class Weak_Reference {

    public static void main(String[] args) throws InterruptedException {
        int i =0;
        List<WeakReference<Ref>> list = new ArrayList<>();
        for (;;){
            int i1 = i++;
            list.add(new WeakReference<>(new Ref(i1)));
            System.out.println(i1 + "加到list中");


            TimeUnit.MILLISECONDS.sleep(100);
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
