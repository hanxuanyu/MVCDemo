package com.hxuanyu.commodity.enums;

/**
 * 操作类型枚举类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public enum OperationType {
    /**
     * ADD：增加/上架
     * DELETE：删除/下架
     * UPDATE：修改
     */
    ADD(0),
    DELETE(1),
    UPDATE(2);

    private final int operationValue;

    OperationType(int operationValue) {
        this.operationValue = operationValue;
    }

    public int getOperationValue() {
        return operationValue;
    }
}
