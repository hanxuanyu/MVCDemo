package com.hxuanyu.commodity.utils;

import com.hxuanyu.commodity.beans.Clerk;
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
     *
     * @param msg 消息内容
     * @return 消息对象
     */
    public static Msg successMsg(String msg) {
        return new Msg(200, msg);
    }

    /**
     * 返回失败消息
     *
     * @param msg 消息内容
     * @return 消息对象
     */
    public static Msg errorMsg(String msg) {
        return new Msg(-1, msg);
    }

    /**
     * 生成uid
     * 生成规则：用户名_是否管理员_MD5(用户名 + 用户手机号)
     *
     * @param clerk 用户对象
     * @return uid
     */
    public static String generateUid(Clerk clerk) {
        String clerkName = clerk.getClerkName();
        int clerkAdmin = clerk.getAdmin();
        String clerkPhone = clerk.getPhone();
        StringBuilder sb = new StringBuilder();
        sb.append(clerkName)
                .append("_")
                .append(clerkAdmin)
                .append("_");
        String md5 = Md5Encrypt.md5(clerkName + clerkPhone);
        sb.append(md5);
        return sb.toString();
    }


}
