package com.hxuanyu.commodity.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类，用于完成获取连接、关闭连接等操作
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class JdbcUtils {

    /**
     * 获取连接
     *
     * @return MySQl连接对象
     * @throws Exception 异常
     * @author hanxuanyu
     */
    public static Connection getConnection() throws Exception {
        // 1. 读取配置
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties pros = new Properties();
        pros.load(is);
        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        // 2. 加载驱动
        Class.forName(driverClass);

        // 3. 获取连接
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * 关闭资源
     *
     * @param conn 要关闭的连接
     * @param ps   要关闭的PreparedStatement
     * @author hxuanyu
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 关闭资源
     *
     * @param conn 要关闭的连接对象
     * @param s    要关闭的Statement
     * @param rs   要关闭的结果集
     * @author hxuanyu
     */
    public static void closeResource(Connection conn, Statement s, ResultSet rs) {
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
