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

    public Commodity getCommodityById(int id) {
        String sql = "select id, commodity_name commodityName, origin, production_date productionDate, shelf_life shelfLife from commodity where id = ?";
        return getInstance(Commodity.class, sql, id);
    }

    public int addCommodity(Commodity commodity) {
        String sql = "insert into commodity(commodity_name, origin, production_date, shelf_life) values(?, ?, ?, ?)";
        return update(sql, commodity.getCommodityName(), commodity.getOrigin(), commodity.getProductionDate(), commodity.getShelfLife());
    }

    public int deleteCommodity(int id) {
        String sql = "delete from commodity where id = ?";
        return update(sql, id);
    }

    public int updateCommodity(Commodity commodity) {
        String sql = "update commodity set commodity_name = ?, origin = ?, production_date = ?, shelf_life = ? where id = ?";
        return update(
                sql,
                commodity.getCommodityName(),
                commodity.getOrigin(),
                commodity.getProductionDate(),
                commodity.getShelfLife(),
                commodity.getId()
        );
    }
}
