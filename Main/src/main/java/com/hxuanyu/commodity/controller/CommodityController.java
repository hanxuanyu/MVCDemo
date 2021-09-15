package com.hxuanyu.commodity.controller;

import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 商品控制器
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class CommodityController {

    private static final Logger log = LoggerFactory.getLogger(CommodityController.class);
    CommodityService commodityService;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/commodity")
    public String commodity(Model model) {
        List<Commodity> commodityList = commodityService.getAllCommodity();
        model.addAttribute("commodityList", commodityList);
        return "commodity";
    }

}
