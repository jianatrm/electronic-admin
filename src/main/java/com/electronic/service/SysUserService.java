package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.UserRequest;
import com.electronic.dao.mapper.bo.SysUser;

import java.util.List;

public interface SysUserService {

    public SysUser selectSysUser(SysUser user) throws Exception;

    public Integer addSysUser(SysUser user) throws Exception;

    public Integer updateSysUser(SysUser user) throws Exception;

    public BaseResponse<PageResult<SysUser>> queryuser(UserRequest userRequest) throws Exception;

}
