package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.service.SysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private SysMenuService sysMenuService;
    @RequestMapping("queryMenuAndRoles")
    @ResponseBody
    public BaseResponse queryMenuAndRoles() throws Exception {
        BaseResponse baseResponse = sysMenuService.queryMenuAndRoles();
        return  baseResponse;
    }

}
