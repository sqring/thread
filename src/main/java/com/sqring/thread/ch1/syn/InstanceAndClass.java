package com.sqring.thread.ch1.syn;

import com.sqring.thread.SleepTools;

/**
 * 描述: 演示实例锁和类锁是不同的，两者可以并行
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 00:45:02
 */
public class InstanceAndClass {

    private static class SynClass extends Thread {
        @Override
        public void run() {
            System.out.println("TestClass is running...");
            synClass();
        }
    }

    private static class InstanceSyn implements Runnable {
        private InstanceAndClass SynClassAndInstance;

        public InstanceSyn(InstanceAndClass SynClassAndInstance) {
            this.SynClassAndInstance = SynClassAndInstance;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..." + SynClassAndInstance);
            SynClassAndInstance.instance();
        }
    }

    private synchronized void instance() {
        SleepTools.second(1);
        System.out.println("synInstance is going..." + this.toString());
        SleepTools.second(1);
        System.out.println("synInstance ended " + this.toString());
    }

    private static synchronized void synClass() {
        SleepTools.second(1);
        System.out.println("synClass going...");
        SleepTools.second(1);
        System.out.println("synClass end");
    }

    public static void main(String[] args) {
        InstanceAndClass synClassAndInstance = new InstanceAndClass();
        Thread t1 = new SynClass();
        Thread t2 = new Thread(new InstanceSyn(synClassAndInstance));
        t2.start();
        SleepTools.second(1);
        t1.start();
    }
}
