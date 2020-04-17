package com.electronic.controller;

import com.alibaba.fastjson.JSON;
import com.electronic.base.modle.BaseResponse;
import com.electronic.base.modle.SessionUser;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.utils.SessionUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/userInfo")
    @ResponseBody
    public BaseResponse userInfo() {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        baseResponse.setResult(sessionUser);
        return baseResponse;

    }




}