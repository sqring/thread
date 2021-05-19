package com.sqring.thread;

import java.util.concurrent.TimeUnit;

/**
 * 描述：线程休眠辅助工具类
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 00:03:59
 */
public class SleepTools {

    /**
     * 按秒休眠
     * @param seconds 秒数
     */
    public static final void second(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 按毫秒数休眠
     * @param seconds 毫秒数
     */
    public static final void ms(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
