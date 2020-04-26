package com.electronic.controller;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.SessionUser;
import com.electronic.base.VO.UserRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.service.SysUserService;
import com.electronic.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    public static  final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    private SysUserService sysUserService;




    /*
    查询用户
     */
    @RequestMapping("queryuser")
    public BaseResponse queryuser(@RequestBody UserRequest userRequest) throws Exception {
        BaseResponse<PageResult<UserRequest>> baseResponse = sysUserService.queryuser(userRequest);
        return baseResponse;
    }

    /*
    添加用户
     */
    @RequestMapping("adduser")
    public BaseResponse adduser(@RequestBody UserRequest userRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);

        String userName = userRequest.getUserName();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        SysUser selectSysUser = sysUserService.selectSysUser(sysUser);
        if (selectSysUser!=null){
            baseResponse.setResultMessage("用户名已存在");
            return baseResponse;
        }


        BeanUtils.copyProperties(userRequest,sysUser);
        SessionUser sessionUser = SessionUtils.getSessionUser();
        sysUser.setOperator(String.valueOf(sessionUser.getUserId()));
        Integer integer = sysUserService.addSysUser(sysUser);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }



    /*
   更新用户
    */
    @RequestMapping("updateuser")
    public BaseResponse updateuser(@RequestBody UserRequest userRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userRequest,sysUser);
        SessionUser sessionUser = SessionUtils.getSessionUser();
        sysUser.setOperator(String.valueOf(sessionUser.getUserId()));
        Integer integer = sysUserService.updateSysUser(sysUser);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }
}
