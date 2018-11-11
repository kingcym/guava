package com.cai.ya.cache.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *WeakReference（弱引用）:
 * 当发生GC(MinorGC/FullGC)时，都会被回收掉。
 */
public class Phantom_Reference {

    public static void main(String[] args) throws InterruptedException {

        Object object = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<Object>();
        Reference<Object> reference = new PhantomReference<Object>(object,
                referenceQueue);
        System.out.println(reference);
        System.out.println(reference.isEnqueued());
        object = null;
        System.gc();
        System.out.println(reference.isEnqueued());
        try {
            System.out.println(referenceQueue.remove(2000));
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
