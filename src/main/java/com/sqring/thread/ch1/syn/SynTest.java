package com.sqring.thread.ch1.syn;

/**
 * 描述: synchronized关键字的使用方法
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/20 00:34:31
 */
public class SynTest {

    private long count =0;
    private Object obj = new Object();//作为一个锁

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    /*用在同步块上*/
    public void incCount(){
        synchronized (obj){
            count++;
        }
    }

    /*用在方法上*/
    public synchronized void incCount2(){
        count++;
    }

    /*用在同步块上，但是锁的是当前类的对象实例*/
    public void incCount3(){
        synchronized (this){
            count++;
        }
    }

    //线程
    private static class Count extends Thread{

        private SynTest simplOper;

        public Count(SynTest simplOper) {
            this.simplOper = simplOper;
        }

        @Override
        public void run() {
            for(int i=0;i<10000;i++){
                simplOper.incCount();//count = count+10000
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynTest simplOper = new SynTest();
        //启动两个线程
        Count count1 = new Count(simplOper);
        Count count2 = new Count(simplOper);
        count1.start();
        count2.start();
        Thread.sleep(50);
        System.out.println(simplOper.count);//20000
    }
}
