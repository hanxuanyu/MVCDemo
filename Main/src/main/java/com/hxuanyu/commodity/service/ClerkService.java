package com.hxuanyu.commodity.service;

import com.hxuanyu.commodity.beans.Clerk;

import java.util.List;

/**
 * 用户相关操作
 *
 * @author hanxuanyu
 */
public interface ClerkService {
    /**
     * 获取所有店员对象
     *
     * @return 店员列表
     */
    List<Clerk> getAllClerk();

    /**
     * 通过id查询店员
     *
     * @param id 店员id
     * @return 店员对象
     */
    Clerk getClerkById(String id);
}
