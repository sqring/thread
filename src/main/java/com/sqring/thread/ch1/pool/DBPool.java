package com.sqring.thread.ch1.pool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 描述: 连接池的实现
 *
 * @author www.zhouwenfang.com
 * @version 1.0
 * @date 2021/05/21 22:11:52
 */
public class DBPool {
    private static LinkedList<Connection> pool = new LinkedList<Connection>();

    public DBPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(SqlConnectImpl.fetchConnection());
            }
        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            //TODO
        }
    }

    // 在mills内无法获取到连接，将会返回null
    public Connection fetchConnection(long mills) throws InterruptedException {
        //TODO
        return null;
    }
}
