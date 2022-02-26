package com.yzy.myssm.basedao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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

    public static String DRIVER;
    public static String URL;
    public static String USER;
    public static String PWD;

    static Properties properties=new Properties();
    static {

        InputStream inputStream = ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(inputStream);
//            DRIVER= properties.getProperty("jdbc.driver");
//            URL= properties.getProperty("jdbc.url");
//            USER= properties.getProperty("jdbc.user");
//            PWD= properties.getProperty("jdbc.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection createConn() {
        try {
            DataSource druidDataSource = DruidDataSourceFactory.createDataSource(properties);
            //方式一
            /*
            DruidDataSource druidDataSource=new DruidDataSource();
            druidDataSource.setDriverClassName(DRIVER);
            druidDataSource.setUrl(URL);
            druidDataSource.setUsername(USER);
            druidDataSource.setPassword(PWD);
            */
            return druidDataSource.getConnection();


//            Class.forName(DRIVER);
//            return DriverManager.getConnection(URL, USER, PWD);
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
