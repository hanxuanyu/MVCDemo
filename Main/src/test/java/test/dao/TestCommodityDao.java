package test.dao;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.dao.CommodityDao;
import com.hxuanyu.commodity.dao.impl.CommodityDaoImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 商品操作测试类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class TestCommodityDao {

    CommodityDao commodityDao = new CommodityDaoImpl();

    @Test
    public void testGetAllCommodity() {
        List<Commodity> commodityList = commodityDao.getAllCommodity();
        for (Commodity commodity : commodityList) {
            System.out.println(commodity);
        }
    }

    @Test
    public void testAddCommodity() {
        int result = commodityDao.addCommodity(new Commodity(
                "草莓",
                "宁波",
                new Date(System.currentTimeMillis()),
                12)
        );
        System.out.println(result);
    }

    @Test
    public void testUpdateCommodity() {
        int result = commodityDao.updateCommodity(
                new Commodity(
                        1,
                        "草莓",
                        "宁波",
                        new Date(System.currentTimeMillis()),
                        1)
        );
        System.out.println(result);
    }

    @Test
    public void testGetCommodity() {
        Commodity commodity = commodityDao.getCommodityById(1);
        System.out.println(commodity);
    }
}
