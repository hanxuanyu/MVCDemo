package com.hxuanyu.commodity.service;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.enums.StatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户相关操作
 *
 * @author hanxuanyu
 */
@Service
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
    Clerk getClerkById(int id);

    /**
     * 通过用户名查询店员
     *
     * @param name 用户名
     * @return 用户对象
     */
    Clerk getClerkByName(String name);


    /**
     * 验证用户名和密码是否正确
     *
     * @param clerkName 用户名
     * @param passwd    用户密码
     * @return true：正确， false：错误
     */
    StatusCode checkLogin(String clerkName, String passwd);

    /**
     * 添加用户
     *
     * @param clerk 用户对象
     * @return 状态码
     */
    StatusCode addClerk(Clerk clerk);

    /**
     * 修改用户
     *
     * @param clerk 用户对象
     * @return 状态码
     */
    StatusCode updateClerk(Clerk clerk);

    /**
     * 根据id删除用户
     *
     * @param id 要删除的用户的id
     * @return 状态码
     */
    StatusCode deleteClerkById(int id);

    /**
     * 根据用户名删除用户
     *
     * @param name 要删除的用户的用户名
     * @return 状态码
     */
    StatusCode deleteClerkByName(String name);
}
