package com.sqring.thread.ch8a.vo;

/**
 * 描述: 方法本身运行是否正确的结果类型
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/06/15 23:17:10
 */
public enum TaskResultType {
    Success,/*方法执行完成，业务结果也正确*/
    Failure,/*方法执行完成，业务结果错误*/
    Exception/*方法执行抛出了异常*/
}
