package com.hxuanyu.commodity.dao;

import com.hxuanyu.commodity.beans.Commodity;

import java.util.List;

/**
 * @author hxuanyu
 */
public interface CommodityDao extends BaseDao {
    /**
     * 获取所有店员
     *
     * @return 店员对象列表
     */
    List<Commodity> getAllCommodity();

    /**
     * 根据id获取店员
     *
     * @param id 商品id
     * @return 商品对象
     */
    Commodity getCommodityById(int id);

    /**
     * 增加店员
     *
     * @param commodity 商品对象
     * @return 受影响的行数
     */
    int addCommodity(Commodity commodity);

    /**
     * 删除店员
     *
     * @param id 要删除的店员的id
     * @return 受影响的行数
     */
    int deleteCommodity(int id);

    /**
     * 修改店员
     *
     * @param commodity 新的商品对象
     * @return 受影响的行数
     */
    int updateCommodity(Commodity commodity);


}
