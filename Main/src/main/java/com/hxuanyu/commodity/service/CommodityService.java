package com.hxuanyu.commodity.service;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.dao.CommodityDao;
import com.hxuanyu.commodity.enums.StatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务
 *
 * @author hxuanyu
 */

@Service
public interface CommodityService {

    /**
     * 获取所有商品
     *
     * @return 商品列表
     */
    List<Commodity> getAllCommodity();

    /**
     * 根据id获取商品
     *
     * @param id 商品id
     * @return 状态码
     */
    Commodity getCommodityById(int id);

    /**
     * 新增商品
     *
     * @param commodity 商品对象
     * @return 状态码
     */
    StatusCode addCommodity(Commodity commodity);

    /**
     * 修改商品
     *
     * @param commodity 商品对象
     * @return 状态码
     */
    StatusCode updateCommodity(Commodity commodity);
}
