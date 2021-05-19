package com.sqring.thread.ch1.base;

import java.util.concurrent.ExecutionException;

/**
 * 描述: 新启线程的方式
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/19 23:08:00
 */
public class NewThread {
    /**
     * 扩展自Thread类
     * thread对线程的抽象
     */
    private static class UseThread extends Thread{
        @Override
        public void run() {
            super.run();
            // do my work;
            System.out.println("I am extended Thread");
        }
    }


    /**
     * 实现Runnable接口
     * runnable 对任务的抽象
     */
    private static class UseRunnable implements Runnable{

        @Override
        public void run() {
            // do my work;
            System.out.println("I am implements Runnable");
        }
    }


    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        UseThread useThread = new UseThread();
        useThread.start();

        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();

    }
}
