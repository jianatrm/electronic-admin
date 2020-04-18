package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.SessionUser;
import com.electronic.contants.BusinessConstants;
import com.electronic.utils.SessionUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
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