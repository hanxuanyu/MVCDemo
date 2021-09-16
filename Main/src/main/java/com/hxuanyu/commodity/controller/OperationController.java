package com.hxuanyu.commodity.controller;

import com.hxuanyu.commodity.beans.Operation;
import com.hxuanyu.commodity.service.OperationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * TODO
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Controller
public class OperationController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    OperationService operationService;

    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        List<Operation> operationList = operationService.getAllOperation();
        logger.debug("listSize: " + operationList.size());
        model.addAttribute("operationList", operationList);
        return "operation";
    }
}
