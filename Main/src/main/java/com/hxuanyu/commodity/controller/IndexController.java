package com.hxuanyu.commodity.controller;

import com.hxuanyu.commodity.beans.Msg;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.ClerkService;
import com.hxuanyu.commodity.utils.Constant;
import com.hxuanyu.commodity.utils.MsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 首页控制器：验证用户信息并设置cookie
 *
 * @author hanxuanyu
 * @version 1.0
 */

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    ClerkService clerkService;

    @Autowired
    public void setClerkService(ClerkService clerkService) {
        this.clerkService = clerkService;
    }

    @RequestMapping({"/", "/index"})
    public String index() {
        return "redirect:/commodity";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @ResponseBody
    @PostMapping(value = "/doLogin", produces = "application/json")
    public Msg doLogin(@RequestBody HashMap<String, String> map) {
        if (map == null) {
            return MsgUtil.errorMsg("参数错误");
        }
        String username = map.get("username");
        String password = map.get("password");
        logger.debug("username: " + username + " password: " + password);
        StatusCode statusCode = clerkService.checkLogin(username, password);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("登陆成功");
        } else {
            return MsgUtil.errorMsg(statusCode.toString());
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute(Constant.SESSION_CLERK);
        return "redirect:login";
    }
}
