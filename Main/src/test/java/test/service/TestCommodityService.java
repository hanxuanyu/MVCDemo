package test.service;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.dao.impl.CommodityDaoImpl;
import com.hxuanyu.commodity.service.CommodityService;
import com.hxuanyu.commodity.service.impl.CommodityServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * service层测试类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class TestCommodityService {

    CommodityService commodityService = new CommodityServiceImpl(new CommodityDaoImpl());

    @Test
    public void testGetAllCommodity() {
        List<Commodity> commodityList = commodityService.getAllCommodity();
        for (Commodity commodity : commodityList) {
            System.out.println(commodity);
        }
    }

    @Test
    public void testGetCommodityById() {
        System.out.println(commodityService.getCommodityById(2));
    }

    @Test
    public void testAddCommodity() {
        System.out.println(commodityService.addCommodity(new Commodity(
                "苹果",
                "杭州",
                new Date(System.currentTimeMillis()),
                18
        )));

        System.out.println(commodityService.addCommodity(new Commodity(
                "",
                "杭州",
                new Date(System.currentTimeMillis()),
                18
        )));
    }

    @Test
    public void testUpdateCommodity() {
        System.out.println(commodityService.updateCommodity(new Commodity(
                2,
                "苹果",
                "富阳",
                new Date(System.currentTimeMillis()),
                12
        )));

        System.out.println(commodityService.updateCommodity(new Commodity(
                2,
                "",
                "富阳",
                new Date(System.currentTimeMillis()),
                12
        )));

        System.out.println(commodityService.updateCommodity(new Commodity(
                2001,
                "苹果",
                "富阳",
                new Date(System.currentTimeMillis()),
                12
        )));
    }

    @Test
    public void testDeleteCommodity() {
        System.out.println(commodityService.deleteCommodity(5));
        System.out.println(commodityService.deleteCommodity(5000));
        System.out.println(commodityService.deleteCommodity(2));
    }
}
