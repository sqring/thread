package com.sqring.thread.ch2.tools;

import com.sqring.thread.SleepTools;
import java.util.concurrent.CountDownLatch;

/**
 * 描述: 演示CountDownLatch用法，
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/21 23:14:50
 */
public class UseCountDownLatch {

   static CountDownLatch latch = new CountDownLatch(6);

    /*初始化线程*/
    private static class InitThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread_"+Thread.currentThread().getId()
                    +" ready init work......");
            latch.countDown();
            for(int i =0;i<2;i++) {
                System.out.println("Thread_"+Thread.currentThread().getId()
                        +" ........continue do its work");
            }
        }
    }

    private static class BusiThread implements Runnable {

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("BusiThread_" + Thread.currentThread().getId()
                        + " do business-----");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SleepTools.ms(1);
                System.out.println("Thread_" + Thread.currentThread().getId()
                        + " ready init work step 1st......");
                latch.countDown();
                System.out.println("begin step 2nd.......");
                SleepTools.ms(1);
                System.out.println("Thread_" + Thread.currentThread().getId()
                        + " ready init work step 2nd......");
                latch.countDown();
            }
        }).start();
        new Thread(new BusiThread()).start();
        for (int i = 0; i <= 3; i++) {
            Thread thread = new Thread(new InitThread());
            thread.start();
        }
        latch.await();
        System.out.println("Main do ites work........");
    }
}
