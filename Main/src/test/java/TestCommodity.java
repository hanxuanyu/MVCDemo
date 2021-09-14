import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.dao.CommodityDao;
import com.hxuanyu.commodity.dao.impl.CommodityDaoImpl;
import org.junit.Test;

import java.util.List;

/**
 * 商品操作测试类
 *
 * @author hanxuanyu
 * @version 1.0
 */
public class TestCommodity {
    @Test
    public void testGetAllCommodity() {
        CommodityDao commodityDao = new CommodityDaoImpl();
        List<Commodity> commodityList = commodityDao.getAllCommodity();
        for (Commodity commodity : commodityList) {
            System.out.println(commodity);
        }
    }
}
