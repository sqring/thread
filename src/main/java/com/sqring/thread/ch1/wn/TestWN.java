package com.sqring.thread.ch1.wn;

/**
 * 描述: 测试wait/notify/notifyAll
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/21 00:17:20
 */
public class TestWN {
    private static Express express = new Express(0, Express.CITY);

    /*检查里程数变化的线程,不满足条件，线程一直等待*/
    private static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitKm();
        }
    }

    /*检查地点变化的线程,不满足条件，线程一直等待*/
    private static class CheckSite extends Thread {
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new CheckSite().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }

        Thread.sleep(1);
        express.changeKm();//快递地点变化
    }
}
