package com.sqring.thread.ch8a.demo;

import com.sqring.thread.SleepTools;
import com.sqring.thread.ch8a.vo.ITaskProcesser;
import com.sqring.thread.ch8a.vo.TaskResult;
import com.sqring.thread.ch8a.vo.TaskResultType;

import java.util.Random;

/**
 * 描述: 一个实际任务类，将数值加上一个随机数，并休眠随机时间
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/06/15 23:20:19
 */
public class MyTask implements ITaskProcesser<Integer, Integer> {

    @Override
    public TaskResult<Integer> taskExecute(Integer data) {
        Random r = new Random();
        int flag = r.nextInt(500);
        SleepTools.ms(flag);
        if (flag <= 300) {//正常处理的情况
            Integer returnValue = data.intValue() + flag;
            return new TaskResult<Integer>(TaskResultType.Success, returnValue);
        } else if (flag > 301 && flag <= 400) {//处理失败的情况
            return new TaskResult<Integer>(TaskResultType.Failure, -1, "Failure");
        } else {//发生异常的情况
            try {
                throw new RuntimeException("异常发生了！！");
            } catch (Exception e) {
                return new TaskResult<Integer>(TaskResultType.Exception,
                        -1, e.getMessage());
            }
        }
    }

}
