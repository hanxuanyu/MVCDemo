package com.hxuanyu.commodity.dao.impl;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.dao.CommodityDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 商品数据库操作
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Repository
public class CommodityDaoImpl extends BaseDaoImpl implements CommodityDao {
    public List<Commodity> getAllCommodity() {
        String sql = "select id, commodity_name commodityName, origin, production_date productionDate, shelf_life shelfLife from commodity";
        List<Commodity> commodityList = getInstanceList(Commodity.class, sql);
        if (commodityList != null && commodityList.size() > 0) {
            return commodityList;
        }
        return null;
    }

    public Commodity getCommodityById(String id) {
        return null;
    }

    public int addCommodity(Commodity commodity) {

        return 0;
    }

    public int deleteCommodity(int id) {
        return 0;
    }

    public int updateCommodity(Commodity commodity) {
        return 0;
    }
}
