package com.sqring.thread.ch4.aqs;

import com.sqring.thread.SleepTools;

import java.util.concurrent.locks.Lock;

/**
 * 描述: 测试独占锁
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/06/05 12:23:40
 */
public class TestMyLock {

    public void test() {
        final Lock lock = new SelfLock();
        class Worker extends Thread {

            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
                try {
                    SleepTools.second(1);
                } finally {
                    lock.unlock();
                }
            }
        }
        // 启动4个子线程
        for (int i = 0; i < 4; i++) {
            Worker w = new Worker();
            //w.setDaemon(true);
            w.start();
        }
        // 主线程每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            //System.out.println();
        }
    }

    public static void main(String[] args) {
        TestMyLock testMyLock = new TestMyLock();
        testMyLock.test();
    }
}
