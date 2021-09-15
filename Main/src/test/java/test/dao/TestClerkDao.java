package test.dao;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.dao.ClerkDao;
import com.hxuanyu.commodity.dao.impl.ClerkDaoImpl;
import com.hxuanyu.commodity.utils.JdbcUtils;
import org.junit.Test;

import java.util.List;

/**
 * 数据库相关测试
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class TestClerkDao {

    @Test
    public void testConnection() throws Exception {
        System.out.println(JdbcUtils.getConnection());
    }

    @Test
    public void testGetClerk() {
        ClerkDao clerkDao = new ClerkDaoImpl();
        System.out.println(clerkDao.getClerkById(1));
    }

    @Test
    public void testGetAllClerk() {
        ClerkDao clerkDao = new ClerkDaoImpl();
        List<Clerk> allClerk = clerkDao.getAllClerk();
        for (Clerk clerk : allClerk) {
            System.out.println(clerk);
        }
    }

    @Test
    public void testAddClerk() {
        ClerkDao clerkDao = new ClerkDaoImpl();
        int result = clerkDao.addClerk(new Clerk("hxuanyu", 1, "16634010219", 0, "123456"));
        System.out.println(result);
    }

    @Test
    public void testDeleteClerk() {
        ClerkDao clerkDao = new ClerkDaoImpl();
        int i = clerkDao.deleteClerk(1);
        System.out.println(i);
    }

    @Test
    public void testUpdateClerk() {
        ClerkDao clerkDao = new ClerkDaoImpl();
        int result = clerkDao.updateClerk(new Clerk(1, "hxy", 0, "123456", 0, "123456"));
        System.out.println(result);
    }
}
