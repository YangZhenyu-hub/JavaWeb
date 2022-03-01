package com.yzy.myssm.trans;

import com.yzy.myssm.basedao.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName TransactionManger
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 16:07
 * @Version
 **/
public class TransactionManger {

    //开启事务
    public static void beginTrans() throws SQLException {
        //将autocommit设为false
        ConnUtil.getConn().setAutoCommit(false);
    }

    //提交事务
    public static void commit() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.commit();
        ConnUtil.closeConn();
    }

    //回滚事务
    public static void rollback() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.rollback();
        ConnUtil.closeConn();
    }

}
