package com.hxuanyu.commodity.controller;

import com.hxuanyu.commodity.beans.Clerk;
import com.hxuanyu.commodity.beans.Commodity;
import com.hxuanyu.commodity.beans.Msg;
import com.hxuanyu.commodity.enums.StatusCode;
import com.hxuanyu.commodity.service.ClerkService;
import com.hxuanyu.commodity.utils.CommonUtils;
import com.hxuanyu.commodity.utils.MsgUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 店员控制器
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
@RequestMapping("/clerk")
public class ClerkController {
    private static final Logger logger = LoggerFactory.getLogger(ClerkController.class);

    private ClerkService clerkService;

    @Autowired
    public void setClerkService(ClerkService clerkService) {
        this.clerkService = clerkService;
    }

    @GetMapping
    public String clerk(Model model) {
        List<Clerk> clerkList = clerkService.getAllClerk();
        model.addAttribute("clerkList", clerkList);
        return "clerk";
    }

    @PostMapping("/add")
    @ResponseBody
    public Msg add(@RequestBody Map<String, String> map) {
        String clerkName = map.get("clerk_name");
        String clerkGenderString = map.get("clerk_gender");
        String clerkPhone = map.get("clerk_phone");
        String clerkPassword = map.get("clerk_password");
        int clerkGender = Integer.parseInt(clerkGenderString);
        Clerk clerk = new Clerk(clerkName, clerkGender, clerkPhone, 0, clerkPassword);
        logger.debug("即将添加用户：" + clerk);
        StatusCode statusCode = clerkService.addClerk(clerk);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("添加成功");
        }
        return MsgUtil.errorMsg(statusCode.toString());
    }

    @PostMapping("/delete")
    @ResponseBody
    public Msg delete(@RequestBody Map<String, String> map) {
        String idString = map.get("clerk_id");
        if (idString == null) {
            return MsgUtil.errorMsg("id为空");
        }
        logger.debug("即将删除用户id：" + idString);
        int id = Integer.parseInt(idString);
        StatusCode statusCode = clerkService.deleteClerkById(id);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("删除成功");
        }
        return MsgUtil.errorMsg(statusCode.toString());
    }


    @PostMapping("/update")
    @ResponseBody
    public Msg update(@RequestBody Map<String, String> map) {
        String clerkIdString = map.get("clerk_id");
        String clerkName = map.get("clerk_name");
        String clerkPhone = map.get("clerk_phone");
        String clerkGenderString = map.get("clerk_gender");
        String clerkPassword = map.get("clerk_password");
        int clerkId = Integer.parseInt(clerkIdString);
        int clerkGender = Integer.parseInt(clerkGenderString);
        Clerk clerk = new Clerk(clerkId, clerkName, clerkGender, clerkPhone, 0, clerkPassword);
        logger.debug("即将更新商品：" + clerk);
        StatusCode statusCode = clerkService.updateClerk(clerk);
        if (statusCode.equals(StatusCode.SUCCESS)) {
            return MsgUtil.successMsg("添加成功");
        }
        return MsgUtil.errorMsg(statusCode.toString());
    }

}
