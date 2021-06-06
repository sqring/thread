package com.sqring.thread.ch4.aqs;

import com.sqring.thread.SleepTools;

import java.util.concurrent.locks.Lock;

/**
 * 描述:
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/06/05 12:28:25
 */
public class TestReenterSelfLock {

    static final Lock lock = new SelfLock();

    public void reenter(int x){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+":递归层级:"+x);
            int y = x - 1;
            if (y==0) {
                return;
            } else{
                reenter(y);
            }
        } finally {
            lock.unlock();
        }

    }

    public void test() {
        class Worker extends Thread {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                SleepTools.second(1);
                reenter(3);
            }
        }
        // 启动3个子线程
        for (int i = 0; i < 3; i++) {
            Worker w = new Worker();
            w.start();
        }
        // 主线程每隔1秒换行
        for (int i = 0; i < 100; i++) {
            SleepTools.second(1);
        }
    }

    public static void main(String[] args) {
        TestReenterSelfLock testMyLock = new TestReenterSelfLock();
        testMyLock.test();
    }
}
