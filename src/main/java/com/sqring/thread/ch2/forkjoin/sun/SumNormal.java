package com.sqring.thread.ch2.forkjoin.sun;

import com.sqring.thread.SleepTools;

/**
 * 描述:
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/21 22:50:57
 */
public class SumNormal {

    public static void main(String[] args) {
        int count = 0;
        int[] src = MakeArray.makeArray();

        long start = System.currentTimeMillis();
        for (int i = 0; i < src.length; i++) {
            SleepTools.ms(1);
            count = count + src[i];
        }
        System.out.println("The count is " + count
                + " spend time:" + (System.currentTimeMillis() - start) + "ms");
    }

}
