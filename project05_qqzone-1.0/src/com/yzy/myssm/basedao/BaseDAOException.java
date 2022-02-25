package com.yzy.myssm.basedao;

/**
 * @ClassName BaseDAOException
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 11:22
 * @Version
 **/
public class BaseDAOException extends RuntimeException {
    BaseDAOException(String msg) {
        super(msg);
    }
}
