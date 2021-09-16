package com.hxuanyu.commodity.service.impl;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.dao.CommodityDao;
import com.hxuanyu.commodity.enums.OperationType;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.CommodityService;
import com.hxuanyu.commodity.service.OperationService;
import com.hxuanyu.commodity.utils.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品服务
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Service
public class CommodityServiceImpl implements CommodityService {
    public static final Logger log = LoggerFactory.getLogger(CommodityServiceImpl.class);
    CommodityDao commodityDao;
    private HttpSession session;
    OperationService operationService;

    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    @Autowired
    public void setSession(HttpSession session) {
        this.session = session;
    }

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
        int commodityId = commodityDao.addCommodity(commodity);
        if (commodityId > 0) {
            if (session != null) {
                Clerk clerk = (Clerk) session.getAttribute(Constant.SESSION_CLERK);
                StatusCode statusCode = operationService.addOperation(new Operation(
                        clerk.getId(),
                        commodityId,
                        new Date(System.currentTimeMillis()),
                        OperationType.ADD_COMMODITY.value(),
                        clerk.getClerkName(),
                        commodity.getCommodityName()
                ));
                log.debug("添加操作记录" + statusCode);
            }
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
            if (session != null) {
                Clerk clerk = (Clerk) session.getAttribute(Constant.SESSION_CLERK);
                StatusCode statusCode = operationService.addOperation(new Operation(
                        clerk.getId(),
                        commodity.getId(),
                        new Date(System.currentTimeMillis()),
                        OperationType.UPDATE_COMMODITY.value(),
                        clerk.getClerkName(),
                        commodity.getCommodityName()
                ));
                log.debug("添加操作记录" + statusCode);
            }
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
            Clerk clerk = (Clerk) session.getAttribute(Constant.SESSION_CLERK);
            StatusCode statusCode = operationService.addOperation(new Operation(
                    clerk.getId(),
                    id,
                    new Date(System.currentTimeMillis()),
                    OperationType.DELETE_COMMODITY.value(),
                    clerk.getClerkName(),
                    temp.getCommodityName()

            ));
            log.debug("添加操作记录" + statusCode);
            return StatusCode.SUCCESS;
        }
        return StatusCode.FAILED;
    }
}
