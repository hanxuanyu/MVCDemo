package com.hxuanyu.commodity.dao;


import java.util.List;

/**
 * @author hxuanyu
 */
public interface BaseDao {

    /**
     * 增加操作
     *
     * @param sql  sql语句
     * @param args 占位符参数
     * @return 新增字段后自动生成的序列值
     */
    int insert(String sql, Object... args);

    /**
     * 删除语句
     * @param sql sql
     * @param args 占位符参数
     * @return 受影响的行数
     *
     */
    int delete(String sql, Object... args);


    /**
     * 通用增删改操作
     *
     * @param sql  sql语句
     * @param args 占位符
     * @return 受影响的行数
     */
    int update(String sql, Object... args);

    /**
     * 通用查询操作
     *
     * @param clazz: 查询结果对应的Bean
     * @param sql:   sql语句
     * @param args:  占位符参数
     * @return T Bean对象
     */
    <T> T getInstance(Class<T> clazz, String sql, Object... args);

    /**
     * 通用查询操作，返回列表
     *
     * @param clazz: 查询结果对应的Bean
     * @param sql:   sql语句
     * @param args:  占位符参数
     * @return T Bean对象
     */
    <T> List<T> getInstanceList(Class<T> clazz, String sql, Object... args);
}
