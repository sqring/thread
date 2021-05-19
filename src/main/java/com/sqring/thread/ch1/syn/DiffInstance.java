package com.sqring.thread.ch1.syn;

import com.sqring.thread.SleepTools;

/**
 * 描述: 锁的实例不一样，也是可以并行的
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 00:48:26
 */
public class DiffInstance {

    private static class InstanceSyn implements Runnable{
        private DiffInstance diffInstance;

        public InstanceSyn(DiffInstance diffInstance) {
            this.diffInstance = diffInstance;
        }

        @Override
        public void run() {
            System.out.println("TestInstance is running..."+ diffInstance);
            diffInstance.instance();
        }
    }

    private static class Instance2Syn implements Runnable{
        private DiffInstance diffInstance;

        public Instance2Syn(DiffInstance diffInstance) {
            this.diffInstance = diffInstance;
        }
        @Override
        public void run() {
            System.out.println("TestInstance2 is running..."+ diffInstance);
            diffInstance.instance2();
        }
    }

    private synchronized void instance(){
        SleepTools.second(3);
        System.out.println("synInstance is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance ended "+this.toString());
    }

    private synchronized void instance2(){
        SleepTools.second(3);
        System.out.println("synInstance2 is going..."+this.toString());
        SleepTools.second(3);
        System.out.println("synInstance2 ended "+this.toString());
    }

    public static void main(String[] args) {
        DiffInstance instance1 = new DiffInstance();
        Thread t3 = new Thread(new Instance2Syn(instance1));
        DiffInstance instance2 = new DiffInstance();
        Thread t4 = new Thread(new InstanceSyn(instance1));
        t3.start();
        t4.start();
        SleepTools.second(1);
    }
}
