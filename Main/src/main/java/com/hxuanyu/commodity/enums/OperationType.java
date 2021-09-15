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

    public int value() {
        return operationValue;
    }


    /**
     * 判断value是否在枚举类型的定义之内
     *
     * @param value 要判断的类型，int
     * @return 如果在返回true，不在返回false
     */
    public static boolean containsValue(int value) {
        OperationType[] values = OperationType.values();
        for (OperationType operationType : values) {
            if (operationType.value() == value) {
                return true;
            }
        }
        return false;
    }
}
