package test.service;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.dao.impl.ClerkDaoImpl;
import com.hxuanyu.commodity.service.impl.ClerkServiceImpl;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * ClerkService测试类
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Ignore
public class TestClerkService {
    ClerkServiceImpl clerkService = new ClerkServiceImpl();

    {
        clerkService.setClerkDao(new ClerkDaoImpl());
    }

    @Test
    public void testGetAllClerk() {
        List<Clerk> allClerk = clerkService.getAllClerk();
        for (Clerk clerk : allClerk) {
            System.out.println(clerk);
        }
    }

    @Test
    public void testGetClerkById() {
        Clerk clerk = clerkService.getClerkById(2);
        System.out.println(clerk);
    }

    @Test
    public void testCheckLogin() {
        System.out.println(clerkService.checkLogin("hxuanyu1", "123456"));
        System.out.println(clerkService.checkLogin("", "123"));
        System.out.println(clerkService.checkLogin("123", ""));
        System.out.println(clerkService.checkLogin("fgdgfdgdg", "123"));
        System.out.println(clerkService.checkLogin("hxuanyu1", "123"));
    }

    @Test
    public void testAddClerk() {
        System.out.println(clerkService.addClerk(new Clerk("", 0, "12324324", 0, "123123")));
        System.out.println(clerkService.addClerk(new Clerk("user1", 0, "", 0, "")));
        System.out.println(clerkService.addClerk(new Clerk("user1", 0, "12324324", 0, "123123")));
        System.out.println(clerkService.addClerk(new Clerk("user2", 0, "12324324", 0, "123123")));
    }

    @Test
    public void testUpdateClerk() {
        System.out.println(clerkService.updateClerk(new Clerk("", 0, "12324324", 0, "123123")));
        System.out.println(clerkService.updateClerk(new Clerk("user1", 0, "", 0, "")));
        System.out.println(clerkService.updateClerk(new Clerk(2, "ImNotExist123", 0, "12324324", 0, "123123")));
        System.out.println(clerkService.updateClerk(new Clerk(3, "user2", 0, "12324324", 0, "123123123")));
    }

    @Test
    public void testDelete() {
        System.out.println(clerkService.deleteClerkById(1));
        System.out.println(clerkService.deleteClerkByName("user1"));
        System.out.println(clerkService.deleteClerkByName(""));
        System.out.println(clerkService.deleteClerkByName(null));
        System.out.println(clerkService.deleteClerkById(3));
    }
}
