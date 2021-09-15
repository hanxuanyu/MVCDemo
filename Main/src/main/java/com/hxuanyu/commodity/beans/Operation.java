package com.hxuanyu.commodity.beans;

import com.hxuanyu.commodity.enums.OperationType;

import java.util.Date;

/**
 * 操作bean
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class Operation {
    private int id;
    private int userId;
    private int commodityId;
    private Date operationTime;
    private int operationType;

    public Operation() {

    }

    public Operation(int userId, int commodityId, OperationType operationType) {
        this.userId = userId;
        this.commodityId = commodityId;
        this.operationType = operationType.value();
    }

    public Operation(int userId, int commodityId, Date operationTime, OperationType operationType) {
        this(userId, commodityId, operationType);
        this.operationTime = operationTime;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", userId=" + userId +
                ", commodityId=" + commodityId +
                ", operationTime=" + operationTime +
                ", operationType=" + operationType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }
}