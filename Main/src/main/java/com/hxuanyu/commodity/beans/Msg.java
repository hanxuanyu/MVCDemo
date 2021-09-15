package com.hxuanyu.commodity.beans;

/**
 * 消息实体类，用于向浏览器返回Ajax请求状态信息
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class Msg {
    private int code;
    private String msg;

    public Msg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MsgBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
