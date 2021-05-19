package com.sqring.thread.ch1.base.safeend;

/**
 * 描述: 实现接口Runnable的线程如何中断
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/19 23:34:32
 */
public class EndRunnable {
    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName()
                        + " I am implements Runnable.");
            }
            System.out.println(Thread.currentThread().getName()
                    +" interrupt flag is "+Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseRunnable useRunnable = new UseRunnable();
        Thread endThread = new Thread(useRunnable,"endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();
    }

}
