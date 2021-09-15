package com.hxuanyu.commodity.service;

import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.enums.StatusCode;

import java.util.List;

/**
 * 操作服务
 *
 * @author hxuanyu
 */
public interface OperationService {
    /**
     * 获取所有操作记录
     *
     * @return 操作记录列表
     */
    List<Operation> getAllOperation();

    /**
     * 根据id获取操作记录
     *
     * @param id 操作id
     * @return 操作记录了
     */
    Operation getOperationById(int id);

    /**
     * 增加操作记录
     *
     * @param operation 操作记录
     * @return 状态码
     */
    StatusCode addOperation(Operation operation);
}
