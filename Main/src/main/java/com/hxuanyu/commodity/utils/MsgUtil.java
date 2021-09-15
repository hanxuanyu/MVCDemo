package com.hxuanyu.commodity.utils;

import com.hxuanyu.commodity.beans.Msg;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class MsgUtil {
    /**
     * 返回成功的消息
     * @param msg 消息内容
     * @return 消息对象
     */
    public static Msg successMsg(String msg) {
        return new Msg(200, msg);
    }

    /**
     * 返回失败消息
     * @param msg 消息内容
     * @return 消息对象
     */
    public static Msg errorMsg(String msg) {
        return new Msg(-1, msg);
    }
}
