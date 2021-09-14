package com.hxuanyu.commodity.dao.impl;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.dao.ClerkDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 店员数据库操作
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Repository
public class ClerkDaoImpl extends BaseDaoImpl implements ClerkDao {
    public List<Clerk> getAllClerk() {
        String sql = "SELECT id, clerk_name clerkName, gender, phone, admin, passwd FROM `clerk`";
        List<Clerk> clerkList = getInstanceList(Clerk.class, sql);
        if (clerkList != null && clerkList.size() > 0) {
            return clerkList;
        }
        return null;
    }

    public Clerk getClerkById(int id) {
        String sql = "SELECT id id, clerk_name clerkName, gender, phone, admin, passwd FROM `clerk` WHERE `id` = ?";
        return getInstance(Clerk.class, sql, id);
    }

    public int addClerk(Clerk clerk) {
        String sql = "INSERT INTO clerk (clerk_name, gender, phone, admin, passwd) VALUES (?, ?, ?, ?, ?)";
        return update(sql, clerk.getClerkName(), clerk.getGender(), clerk.getPhone(), clerk.getAdmin(), clerk.getPasswd());
    }

    public int deleteClerk(int id) {
        String sql = "delete from clerk where id = ?";
        return update(sql, id);
    }

    public int updateClerk(Clerk clerk) {
        String sql = "update clerk set clerk_name = ?, gender = ?, phone = ?, admin = ?, passwd = ? where id = ?";
        return update(
                sql,
                clerk.getClerkName(),
                clerk.getGender(),
                clerk.getPhone(),
                clerk.getAdmin(),
                clerk.getPasswd(),
                clerk.getId()
        );
    }

    public Clerk getClerkByName(String name) {
        String sql = "SELECT id id, clerk_name clerkName, gender, phone, admin, passwd FROM `clerk` WHERE `clerk_name` = ?";
        return getInstance(Clerk.class, sql, name);
    }
}
