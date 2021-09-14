package com.hxuanyu.commodity.dao;

import com.hxuanyu.commodity.beans.Operation;

import java.util.List;

/**
 * 操作记录
 *
 * @author hxuanyu
 */
public interface OperationDao {
    /**
     * 获取所有操作
     *
     * @return 操作对象列表
     */
    List<Operation> getAllOperation();

    /**
     * 根据id获取操作
     *
     * @param id 操作id
     * @return 操作对象
     */
    Operation getOperationById(int id);

    /**
     * 增加操作
     *
     * @param operation 操作对象
     * @return 受影响的行数
     */
    int addOperation(Operation operation);
}
