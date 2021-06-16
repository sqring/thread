package com.sqring.thread.ch8a.vo;

/**
 * 描述:  任务处理后返回的结果实体类
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/06/15 23:16:31
 */
public class TaskResult<R> {

    private final TaskResultType resultType;/*方法执行结果*/

    private final R returnValue;/*方法执行后的结果数据*/

    private final String reason;/*如果方法失败，这里可以填充原因*/

    public TaskResult(TaskResultType resultType, R returnValue, String reason) {
        super();
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = reason;
    }

    public TaskResult(TaskResultType resultType, R returnValue) {
        super();
        this.resultType = resultType;
        this.returnValue = returnValue;
        this.reason = "Success";
    }

    public TaskResultType getResultType() {
        return resultType;
    }
    public String getReason() {
        return reason;
    }
    public R getReturnValue() {
        return returnValue;
    }

    @Override
    public String toString() {
        return "TaskResult [resultType=" + resultType
                + ", returnValue=" + returnValue
                + ", reason=" + reason + "]";
    }

}
