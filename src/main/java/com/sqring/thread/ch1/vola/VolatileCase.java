package com.sqring.thread.ch1.vola;

import com.sqring.thread.SleepTools;

/**
 * 描述: 演示Volatile的提供的可见性
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 22:32:09
 */
public class VolatileCase {
    private static boolean ready;
    private static int number;

    private static class PrintThread extends Thread {
        @Override
        public void run() {
            System.out.println("PrintThread is running.......");
            while (!ready) { //无限循环
                System.out.println("number = " + number);
            }
        }
    }

    public static void main(String[] args) {
        new PrintThread().start();
        SleepTools.second(1);
        number = 51;
        ready = true;
        SleepTools.second(2);
        System.out.println("main is ended!");
    }
}
