package com.hxuanyu.commodity.dao.impl;

import com.hxuanyu.commodity.dao.BaseDao;
import com.hxuanyu.commodity.utils.JdbcUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseDao实现类
 *
 * @author hanxuanyu
 * @version 1.0
 */
@SuppressWarnings("DuplicatedCode")
public class BaseDaoImpl implements BaseDao {
    /**
     * description: 通用增删改操作
     *
     * @param sql:  sql语句
     * @param args: 占位符填充参数
     * @return int 受影响的行数
     * @author hxuanyu
     */
    public int update(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(conn, ps);
        }
        return 0;
    }

    /**
     * description: 通用查询操作
     *
     * @param clazz: 查询结果对应的Bean
     * @param sql:   sql语句
     * @param args:  占位符参数
     * @return T Bean对象
     * @author hxuanyu
     */
    public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    Field field = t.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(null, ps, rs);
        }
        return null;
    }

    /**
     * description: 通用查询操作，返回列表
     *
     * @param clazz: 查询结果对应的Bean
     * @param sql:   sql语句
     * @param args:  占位符参数
     * @return T Bean对象
     * @author hxuanyu
     */
    public <T> List<T> getInstanceList(Class<T> clazz, String sql, Object... args) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    Field field = t.getClass().getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.closeResource(null, ps, rs);
        }
        return null;
    }
}
