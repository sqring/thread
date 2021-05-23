package com.sqring.thread.ch4.rw;

import com.sqring.thread.SleepTools;

/**
 * 描述: 用内置锁来实现商品服务接口
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/23 23:48:09
 */
public class UseSyn implements GoodsService {

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getNum() {
        SleepTools.ms(5);
        return this.goodsInfo;
    }

    @Override
    public synchronized void setNum(int number) {
        SleepTools.ms(5);
        goodsInfo.changeNumber(number);

    }

}
