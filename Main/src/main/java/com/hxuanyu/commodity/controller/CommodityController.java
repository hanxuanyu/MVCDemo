package com.hxuanyu.commodity.controller;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.beans.Msg;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.CommodityService;
import com.hxuanyu.commodity.utils.CommonUtils;
import com.hxuanyu.commodity.utils.MsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 商品控制器
 *
 * @author hanxuanyu
 * @version 1.0
 */

@SuppressWarnings("DuplicatedCode")
@Controller
@RequestMapping("/commodity")
public class CommodityController {

    private static final Logger log = LoggerFactory.getLogger(CommodityController.class);
    CommodityService commodityService;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("")
    public String commodity(Model model) {
        List<Commodity> commodityList = commodityService.getAllCommodity();
        model.addAttribute("commodityList", commodityList);
        return "commodity";
    }

    @PostMapping("/add")
    @ResponseBody
    public Msg add(@RequestBody Map<String, String> map) {
        String comName = map.get("com_name");
        String comOrigin = map.get("com_origin");
        String comProductionDateString = map.get("com_production_date");
        Date comProductionDate = CommonUtils.getDateFromString(comProductionDateString, "yyyy-MM-dd");
        int comShelfLife = Integer.parseInt(map.get("com_shelf_lift"));
        Commodity commodity = new Commodity(comName, comOrigin, comProductionDate, comShelfLife);
        log.debug("即将添加商品：" + commodity);
        StatusCode statusCode = commodityService.addCommodity(commodity);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("添加成功");
        }
        return MsgUtil.errorMsg(statusCode.toString());
    }

    @PostMapping("/delete")
    @ResponseBody
    public Msg delete(@RequestBody Map<String, String> map) {
        String idString = map.get("com_id");
        if (idString == null) {
            return MsgUtil.errorMsg("id为空");
        }
        log.debug("即将删除的商品id：" + idString);
        int id = Integer.parseInt(idString);
        StatusCode statusCode = commodityService.deleteCommodity(id);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("删除成功");
        }
        return MsgUtil.errorMsg(statusCode.toString());

    }

    @PostMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody Map<String, String> map) {
        String comIdString = map.get("com_id");
        String comName = map.get("com_name");
        String comOrigin = map.get("com_origin");
        String comProductionDateString = map.get("com_production_date");
        Date comProductionDate = CommonUtils.getDateFromString(comProductionDateString, "yyyy-MM-dd");
        int comShelfLife = Integer.parseInt(map.get("com_shelf_lift"));
        int comId = Integer.parseInt(comIdString);
        Commodity commodity = new Commodity(comId, comName, comOrigin, comProductionDate, comShelfLife);
        log.debug("即将更新商品：" + commodity);
        StatusCode statusCode = commodityService.updateCommodity(commodity);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("添加成功");
        }
        return MsgUtil.errorMsg(statusCode.toString());
    }

}
