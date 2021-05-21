package com.sqring.thread.ch2.forkjoin.sort;

import com.sqring.thread.ch2.forkjoin.sun.MakeArray;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 描述: forkjoin实现的归并排序
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/22 00:20:48
 */
public class FkSort {
    private static class SumTask extends RecursiveTask<int[]> {

        private final static int THRESHOLD = 2;
        private int[] src;

        public SumTask(int[] src) {
            this.src = src;
        }

        @Override
        protected int[] compute() {
            if(src.length<=THRESHOLD){
                return InsertionSort.sort(src);
            }else{
                //fromIndex....mid.....toIndex
                int mid = src.length / 2;
                SumTask leftTask = new SumTask(Arrays.copyOfRange(src, 0, mid));
                SumTask rightTask = new SumTask(Arrays.copyOfRange(src, mid, src.length));
                invokeAll(leftTask,rightTask);
                int[] leftResult = leftTask.join();
                int[] rightResult = rightTask.join();
                return MergeSort.merge(leftResult,rightResult);
            }
        }
    }


    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();
        int[] src = MakeArray.makeArray();

        SumTask innerFind = new SumTask(src);

        long start = System.currentTimeMillis();

        int[] invoke = pool.invoke(innerFind);
//        for(int number:invoke){
//            System.out.println(number);
//        }
        System.out.println(" spend time:"+(System.currentTimeMillis()-start)+"ms");

    }
}
