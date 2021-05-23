package com.sqring.thread.ch3;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 描述:
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/23 14:17:20
 */
public class AtomicArray {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);//原数组不会变化
    }
}
