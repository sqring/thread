package com.sqring.thread.ch2.forkjoin.sun;

import java.util.Random;

/**
 * 描述: 创建一个数组
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/21 22:50:08
 */
public class MakeArray {
    //数组长度
    public static final int ARRAY_LENGTH  = 4000;

    public static int[] makeArray() {

        //new一个随机数发生器
        Random r = new Random();
        int[] result = new int[ARRAY_LENGTH];
        for(int i=0;i<ARRAY_LENGTH;i++){
            //用随机数填充数组
            result[i] =  r.nextInt(ARRAY_LENGTH*3);
        }
        return result;

    }
}

