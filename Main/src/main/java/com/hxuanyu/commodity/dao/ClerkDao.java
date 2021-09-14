package com.hxuanyu.commodity.dao;

import com.hxuanyu.commodity.beans.Clerk;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hxuanyu
 */
public interface ClerkDao extends BaseDao {
    /**
     * 获取所有店员
     *
     * @return 店员对象列表
     */
    List<Clerk> getAllClerk();

    /**
     * 根据id获取店员
     *
     * @param id 店员id
     * @return 店员对象
     */
    Clerk getClerkById(int id);

    /**
     * 增加店员
     *
     * @param clerk 店员对象
     * @return 受影响的行数
     */
    int addClerk(Clerk clerk);

    /**
     * 删除店员
     *
     * @param id 要删除的店员的id
     * @return 受影响的行数
     */
    int deleteClerk(int id);

    /**
     * 修改店员
     *
     * @param clerk 新的店员对象
     * @return 受影响的行数
     */
    int updateClerk(Clerk clerk);

    /**
     * 通过用户名获取用户
     *
     * @param name 用户名
     * @return 用户对象
     */
    Clerk getClerkByName(String name);

}
