package com.sqring.thread.ch8a.vo;

/**
 * 描述: 要求框架使用者实现的任务接口，因为任务的性质在调用时才知道，
 *      所以传入的参数和方法的返回值均使用泛型
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/06/15 23:15:58
 */
public interface ITaskProcesser<T, R> {
    TaskResult<R> taskExecute(T data);
}
