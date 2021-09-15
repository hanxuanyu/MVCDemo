package com.hxuanyu.commodity.enums;

/**
 * 操作类型枚举类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public enum OperationType {
    /**
     * 增加商品
     */
    ADD_COMMODITY(1),
    /**
     * 删除商品
     */
    DELETE_COMMODITY(2),
    /**
     * 修改商品
     */
    UPDATE_COMMODITY(3);

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
