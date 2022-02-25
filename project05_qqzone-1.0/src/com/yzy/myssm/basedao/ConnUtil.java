package com.yzy.myssm.basedao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName ConnUtil
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 11:26
 * @Version
 **/
public class ConnUtil {
    private static Connection conn;
    private static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    public static final String DRIVER = "com.mysql.jdbc.Driver" ;
    public static final String URL = "jdbc:mysql://localhost:3306/qqzonedb2?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    public static final String USER = "root";
    public static final String PWD = "#@*yzy123" ;

    public static Connection createConn() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseDAOException("BaseDAO出错 数据库连接获取失败");
        }
    }

    public static Connection getConn() {
        conn=threadLocal.get();
        if (conn == null) {
            conn = createConn();
            threadLocal.set(conn);
        }
        return threadLocal.get();
    }

    public static void closeConn() throws SQLException {
        conn=threadLocal.get();
        if (!conn.isClosed()) {
            conn.close();
            threadLocal.set(null);
        }
    }
}
