package com.hxuanyu.commodity.service.impl;

import ch.qos.logback.classic.Logger;
import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.dao.ClerkDao;
import com.hxuanyu.commodity.dao.impl.ClerkDaoImpl;
import com.hxuanyu.commodity.service.ClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户操作实现类
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Service
public class ClerkServiceImpl implements ClerkService {

    ClerkDao clerkDao;

    @Autowired
    private ClerkServiceImpl(ClerkDaoImpl clerkDao) {
        this.clerkDao = clerkDao;
    }

    public List<Clerk> getAllClerk() {
        List<Clerk> allClerk = clerkDao.getAllClerk();
        for (Clerk clerk : allClerk) {
            clerk.setPasswd(null);
        }
        return allClerk;
    }

    public Clerk getClerkById(String id) {
        Clerk clerk = clerkDao.getClerkById(id);
        clerk.setPasswd(null);
        return clerk;
    }
}
