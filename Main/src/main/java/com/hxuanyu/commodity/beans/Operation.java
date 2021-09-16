package com.hxuanyu.commodity.beans;

import java.util.Date;

/**
 * 操作bean
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class Operation {
    private int id;
    private int clerkId;
    private int commodityId;
    private Date operationTime;
    private int operationType;
    private String clerkName;
    private String commodityName;

    public Operation() {
    }

    public Operation(int clerkId, int commodityId, Date operationTime, int operationType, String clerkName, String commodityName) {
        this.clerkId = clerkId;
        this.commodityId = commodityId;
        this.operationTime = operationTime;
        this.operationType = operationType;
        this.clerkName = clerkName;
        this.commodityName = commodityName;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", clerkId=" + clerkId +
                ", commodityId=" + commodityId +
                ", operationTime=" + operationTime +
                ", operationType=" + operationType +
                ", clerkName='" + clerkName + '\'' +
                ", commodityName='" + commodityName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClerkId() {
        return clerkId;
    }

    public void setClerkId(int clerkId) {
        this.clerkId = clerkId;
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

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
}