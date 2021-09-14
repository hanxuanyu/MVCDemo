package com.hxuanyu.commodity.dao.impl;

import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.dao.OperationDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 操作实体类
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Repository
public class OperationDaoImpl extends BaseDaoImpl implements OperationDao {
    public List<Operation> getAllOperation() {
        String sql = "select id, user_id userId, commodity_id commodityId, operation_time operationTime, operation_type operationType from operation";
        return getInstanceList(Operation.class, sql);
    }

    public Operation getOperationById(int id) {
        String sql = "select id, user_id userId, commodity_id commodityId, operation_time operationTime, operation_type operationType from operation where id = ?";
        return getInstance(Operation.class, sql, id);
    }

    public int addOperation(Operation operation) {
        String sql = "insert into operation(user_id, commodity_id, operation_time, operation_type) values (?, ?, ?, ?)";
        return update(sql, operation.getUserId(), operation.getCommodityId(), operation.getOperationTime(), operation.getOperationType());
    }
}
