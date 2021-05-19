package com.sqring.thread.ch1.base.safeend;

/**
 * 描述：如何安全中断线程
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/19 23:25:59
 */
public class EndThread {
    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " interrupt flag =" + isInterrupted());
            while (!isInterrupted()) {
                //while(!Thread.interrupted()){
                //while(true){
                System.out.println(threadName + " is running");
                System.out.println(threadName + "inner interrupt flag ="
                        + isInterrupted());
            }
            System.out.println(threadName + " interrupt flag =" + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();
        Thread.sleep(20);
        endThread.interrupt();//中断线程，其实设置线程的标识位true


    }
}
