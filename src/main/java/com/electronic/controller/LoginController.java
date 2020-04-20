package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.SessionUser;
import com.electronic.contants.BusinessConstants;
import com.electronic.utils.SessionUtils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("user")
public class LoginController {

    @RequestMapping("/userInfo")
    @ResponseBody
    public BaseResponse userInfo() throws UnsupportedEncodingException {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        baseResponse.setResult(sessionUser);
        return baseResponse;

    }




}