package com.hxuanyu.commodity.service.impl;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.dao.ClerkDao;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.ClerkService;
import com.hxuanyu.commodity.utils.Constant;
import com.hxuanyu.commodity.utils.MsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户操作实现类
 *
 * @author hanxuanyu
 * @version 1.0
 */
@SuppressWarnings("DuplicatedCode")
@Service
public class ClerkServiceImpl implements ClerkService {

    private static final Logger logger = LoggerFactory.getLogger(ClerkServiceImpl.class);

    ClerkDao clerkDao;
    private HttpSession session;

    @Autowired
    public void setClerkDao(ClerkDao clerkDao) {
        this.clerkDao = clerkDao;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

    @Override
    public List<Clerk> getAllClerk() {
        List<Clerk> allClerk = clerkDao.getAllClerk();
        if (allClerk != null && allClerk.size() > 0) {
            return allClerk;
        }
        return new ArrayList<>();
    }

    @Override
    public Clerk getClerkById(int id) {
        return clerkDao.getClerkById(id);
    }

    @Override
    public Clerk getClerkByName(String name) {
        return clerkDao.getClerkByName(name);
    }

    @Override
    public StatusCode checkLogin(String clerkName, String passwd) {
        if (clerkName == null || clerkName.length() == 0) {
            return StatusCode.CLERK_NAME_EMPTY;
        }
        if (passwd == null || passwd.length() == 0) {
            return StatusCode.CLERK_PASSWORD_EMPTY;
        }
        Clerk clerk = getClerkByName(clerkName);
        if (clerk == null) {
            return StatusCode.CLERK_NOT_EXIST;
        }
        if (!clerk.getPasswd().equals(passwd)) {
            return StatusCode.CLERK_PASSWORD_WRONG;
        }
        String uid = MsgUtil.generateUid(clerk);
        logger.debug("生成uid：" + uid);
        clerk.setPasswd("");
        session.setAttribute(Constant.SESSION_CLERK, clerk);
        return StatusCode.SUCCESS;
    }

    @Override
    public StatusCode addClerk(Clerk clerk) {
        if (clerk.getClerkName() == null || clerk.getClerkName().length() == 0) {
            return StatusCode.CLERK_NAME_EMPTY;
        }
        if (clerk.getPasswd() == null || clerk.getPasswd().length() == 0) {
            return StatusCode.CLERK_PASSWORD_EMPTY;
        }
        Clerk temp = getClerkByName(clerk.getClerkName());
        if (temp != null) {
            return StatusCode.CLERK_ALREADY_EXIST;
        }
        int result = clerkDao.addClerk(clerk);
        if (1 == result) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }

    @Override
    public StatusCode updateClerk(Clerk clerk) {
        if (clerk.getClerkName() == null || clerk.getClerkName().length() == 0) {
            return StatusCode.CLERK_NAME_EMPTY;
        }
        if (clerk.getPasswd() == null || clerk.getPasswd().length() == 0) {
            return StatusCode.CLERK_PASSWORD_EMPTY;
        }
        Clerk temp = getClerkByName(clerk.getClerkName());
        if (temp == null) {
            return StatusCode.CLERK_NOT_EXIST;
        }
        if (temp.getAdmin() == 1) {
            clerk.setAdmin(1);
        }
        int result = clerkDao.updateClerk(clerk);
        if (result == 1) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }

    @Override
    public StatusCode deleteClerkById(int id) {
        Clerk temp = clerkDao.getClerkById(id);
        if (temp == null) {
            return StatusCode.CLERK_NOT_EXIST;
        }
        int result = clerkDao.deleteClerk(id);
        if (result == 1) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }

    @Override
    public StatusCode deleteClerkByName(String name) {
        if (name == null || name.length() == 0) {
            return StatusCode.CLERK_NAME_EMPTY;
        }
        Clerk temp = clerkDao.getClerkByName(name);
        if (temp == null) {
            return StatusCode.CLERK_NOT_EXIST;
        }
        int result = clerkDao.deleteClerk(temp.getId());
        if (result == 1) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }


}
