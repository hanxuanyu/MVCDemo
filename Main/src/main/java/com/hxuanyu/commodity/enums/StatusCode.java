package com.hxuanyu.commodity.enums;

/**
 * 用户描述服务端各层之间交互的状态信息
 *
 * @author hanxuanyu
 * @version 1.0
 */
public enum StatusCode {
    /**
     * 操作成功
     */
    SUCCESS("成功"),
    /**
     * 操作失败，原因未知
     */
    FAILED("失败，未知错误"),
    /**
     * 用户不存在
     */
    CLERK_NOT_EXIST("用户不存在"),
    /**
     * 用户已经存在
     */
    CLERK_ALREADY_EXIST("用户已经存在"),
    /**
     * 用户密码错误
     */
    CLERK_PASSWORD_WRONG("用户密码错误"),
    /**
     * 用户名为空
     */
    CLERK_NAME_EMPTY("用户名为空"),
    /**
     * 密码为空
     */
    CLERK_PASSWORD_EMPTY("密码为空"),
    /**
     * 商品不存在
     */
    COMMODITY_NOT_EXISTS("商品不存在"),
    ;


    private final String statusName;

    StatusCode(String statusName) {
        this.statusName = statusName;
    }


    @Override
    public String toString() {
        return statusName;
    }
}
