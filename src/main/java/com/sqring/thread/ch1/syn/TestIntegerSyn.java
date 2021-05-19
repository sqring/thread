package com.sqring.thread.ch1.syn;

/**
 * 描述: 错误的加锁和原因分析
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 00:52:24
 */
public class TestIntegerSyn {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker(1);
        //Thread.sleep(50);
        for (int i = 0; i < 5; i++) {
            new Thread(worker).start();
        }
    }

    private static class Worker implements Runnable {

        private Integer i;
        private Object o = new Object();

        public Worker(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (o) {
                Thread thread = Thread.currentThread();
                System.out.println(thread.getName() + "--@"
                        + System.identityHashCode(i));
                i++;
                System.out.println(thread.getName() + "-------" + i + "-@"
                        + System.identityHashCode(i));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + "-------" + i + "--@"
                        + System.identityHashCode(i));
            }

        }

    }

}
