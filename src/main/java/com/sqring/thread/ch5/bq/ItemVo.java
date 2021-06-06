package com.sqring.thread.ch5.bq;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *类说明：存放的队列的元素，
 */
public class ItemVo<T> implements Delayed {

	//到期时间,但传入的数值代表过期的时长，传入单位毫秒
	private long activeTime;
	private T data;//业务数据，泛型

	//TODO

	public long getActiveTime() {
		return activeTime;
	}

	public T getData() {
		return data;
	}

	/*
	 * 这个方法返回到激活日期的剩余时间，时间单位由单位参数指定。
	 */
	public long getDelay(TimeUnit unit) {
		//TODO
		return 0;
	}

	/*
	 *Delayed接口继承了Comparable接口，按剩余时间排序，实际计算考虑精度为纳秒数
	 */
	public int compareTo(Delayed o) {
		//TODO
		return 0;
	}

}
