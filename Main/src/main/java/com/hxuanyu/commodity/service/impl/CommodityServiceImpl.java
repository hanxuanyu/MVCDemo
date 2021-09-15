package com.hxuanyu.commodity.service.impl;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.dao.CommodityDao;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品服务
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    CommodityDao commodityDao;

    @Autowired
    public CommodityServiceImpl(CommodityDao commodityDao) {
        this.commodityDao = commodityDao;
    }

    @Override
    public List<Commodity> getAllCommodity() {
        List<Commodity> commodityList = commodityDao.getAllCommodity();
        if (commodityList != null) {
            return commodityList;
        }
        return new ArrayList<>();
    }

    @Override
    public Commodity getCommodityById(int id) {
        return commodityDao.getCommodityById(id);
    }

    @Override
    public StatusCode addCommodity(Commodity commodity) {
        if (commodity.getCommodityName() == null || commodity.getCommodityName().length() == 0) {
            return StatusCode.COMMODITY_NAME_EMPTY;
        }
        int result = commodityDao.addCommodity(commodity);
        if (result == 1) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }

    @Override
    public StatusCode updateCommodity(Commodity commodity) {
        if (commodity.getCommodityName() == null || commodity.getCommodityName().length() == 0) {
            return StatusCode.COMMODITY_NAME_EMPTY;
        }
        Commodity temp = getCommodityById(commodity.getId());
        if (temp == null) {
            return StatusCode.COMMODITY_NOT_EXISTS;
        }
        int result = commodityDao.updateCommodity(commodity);
        if (result == 1) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }

    @Override
    public StatusCode deleteCommodity(int id) {
        Commodity temp = getCommodityById(id);
        if (temp == null) {
            return StatusCode.COMMODITY_NOT_EXISTS;
        }
        int result = commodityDao.deleteCommodity(id);
        if (result == 1) {
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }
}
