package com.sqring.thread.ch1.syn;

import com.sqring.thread.SleepTools;

/**
 * 描述: 类锁和锁static变量也是不同的
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 00:51:35
 */
public class StaticAndClass {

    private static class SynClass extends Thread{
        @Override
        public void run() {
            System.out.println(currentThread().getName()
                    +":SynClass is running...");
            synClass();
        }
    }

    private static class SynStatic extends Thread{
        @Override
        public void run() {
            System.out.println(currentThread().getName()
                    +"SynStatic is running...");
            synStatic();
        }
    }

    private static synchronized void synClass(){
        System.out.println(Thread.currentThread().getName()
                +"synClass going...");
        SleepTools.second(1);
        System.out.println(Thread.currentThread().getName()
                +"synClass end");
    }

    private static Object obj = new Object();
    private static void synStatic(){
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()
                    +"synStatic going...");
            SleepTools.second(1);
            System.out.println(Thread.currentThread().getName()
                    +"synStatic end");
        }
    }

    public static void main(String[] args) {
        StaticAndClass synClassAndInstance = new StaticAndClass();
        Thread t1 = new SynClass();
        //Thread t2 = new SynStatic();
        Thread t2 = new SynClass();
        t2.start();
        SleepTools.second(1);
        t1.start();
    }
}
