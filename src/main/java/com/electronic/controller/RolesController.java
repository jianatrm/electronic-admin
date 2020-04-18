package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.request.RolesRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController {
    public static  final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);

    /*
    添加角色
     */
    @RequestMapping("addRoles")
    public BaseResponse addRoles(@RequestBody RolesRequest rolesRequest){

        return null;
    }
}
