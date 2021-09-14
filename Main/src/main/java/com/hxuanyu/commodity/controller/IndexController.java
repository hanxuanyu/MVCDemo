package com.hxuanyu.commodity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器：验证用户信息并设置cookie
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
