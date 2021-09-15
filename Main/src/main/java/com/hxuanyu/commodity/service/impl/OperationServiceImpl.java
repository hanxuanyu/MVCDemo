package com.hxuanyu.commodity.service.impl;

import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.dao.OperationDao;
import com.hxuanyu.commodity.enums.OperationType;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 操作服务
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Service
public class OperationServiceImpl implements OperationService {

    OperationDao operationDao;

    @Autowired
    public OperationServiceImpl(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public List<Operation> getAllOperation() {
        List<Operation> operationList = operationDao.getAllOperation();
        if (operationList != null) {
            return operationList;
        }
        return new ArrayList<Operation>();
    }

    public Operation getOperationById(int id) {
        return operationDao.getOperationById(id);
    }

    public StatusCode addOperation(Operation operation) {
        int operationType = operation.getOperationType();
        if (!OperationType.containsValue(operationType)) {
            return StatusCode.OPERATION_TYPE_ERROR;
        }
        if (operation.getOperationTime() == null) {
            operation.setOperationTime(new Date(System.currentTimeMillis()));
        }
        operationDao.addOperation(operation);

        return null;
    }
}
