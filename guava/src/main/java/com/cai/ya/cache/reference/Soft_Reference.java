package com.cai.ya.cache.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *SoftReference（软引用）:
 * 当发生GC(MinorGC/FullGC)时，当检测到JVM内存快要满了，将GC　Soft　Reference
 * <P>
 *     SoftReference可能会OutOfMemoryError
 *     1.当我们把睡眠时间调制1ms时，会报OutOfMemoryError
 *     2.当我们把睡眠时间调制1s时，程序会一直执行下去，可以看到对象被GC
 *     分析：时间调至1ms，这时还未来得及GC，又放入，会出现堆内存溢出
 *          当1s时，有足够的时间去GC.不会全部GC掉
 *     总结：在缓存中，一般放的次数远远小于放的次数，不可能不断地放入缓存，因此用SoftReference，绝大多时候
 *     不会报OutOfMemoryError
 *
 * <P/>
 */
public class Soft_Reference {

    public static void main(String[] args) throws InterruptedException {
        int i =0;
        List<SoftReference<Ref>> list = new ArrayList<>();
        for (;;){
            int i1 = i++;
            list.add(new SoftReference<>(new Ref(i1)));
            System.out.println(i1 + "加到list中");
            if (i1== 45)
                TimeUnit.MILLISECONDS.sleep(10000);

            TimeUnit.MILLISECONDS.sleep(1000);
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
