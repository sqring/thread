package com.sqring.thread.ch3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述: 演示基本类型的原子操作类
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/23 14:12:38
 */
public class UseAtomicInt {
    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        ai.getAndIncrement();
        ai.incrementAndGet();
        //ai.compareAndSet();
        ai.addAndGet(24);
    }
}
