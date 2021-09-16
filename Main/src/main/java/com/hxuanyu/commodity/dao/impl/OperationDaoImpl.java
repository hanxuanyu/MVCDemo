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
    @Override
    public List<Operation> getAllOperation() {
        String sql = "select id, clerk_id clerkId, commodity_id commodityId, operation_time operationTime, operation_type operationType, clerk_name clerkName, commodity_name commodityName from operation";
        return getInstanceList(Operation.class, sql);
    }

    @Override
    public Operation getOperationById(int id) {
        String sql = "select id, clerk_id clerkId, commodity_id commodityId, operation_time operationTime, operation_type operationType, clerk_name clerkName, commodity_name commodityName from operation where id = ?";
        return getInstance(Operation.class, sql, id);
    }

    @Override
    public int addOperation(Operation operation) {
        String sql = "insert into operation(clerk_id, commodity_id, operation_time, operation_type, clerk_name, commodity_name) values (?, ?, ?, ?, ?, ?)";
        return update(sql, operation.getClerkId(), operation.getCommodityId(), operation.getOperationTime(), operation.getOperationType(), operation.getClerkName(), operation.getCommodityName());
    }
}
