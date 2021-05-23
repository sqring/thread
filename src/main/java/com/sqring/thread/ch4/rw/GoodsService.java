package com.sqring.thread.ch4.rw;

/**
 * 描述: 商品的服务的接口
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/23 23:47:05
 */
public interface GoodsService {

    public GoodsInfo getNum();//获得商品的信息
    public void setNum(int number);//设置商品的数量
}
