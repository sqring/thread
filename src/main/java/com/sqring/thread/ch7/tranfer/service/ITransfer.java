package com.sqring.thread.ch7.tranfer.service;


import com.sqring.thread.ch7.tranfer.UserAccount;

/**
 *
 *类说明：银行转账动作接口
 */
public interface ITransfer {
    void transfer(UserAccount from, UserAccount to, int amount)
    		throws InterruptedException;
}
