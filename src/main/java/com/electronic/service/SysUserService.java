package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.UserRequest;
import com.electronic.dao.mapper.bo.SysUser;

public interface SysUserService {

    public SysUser selectSysUser(SysUser user) throws Exception;

    public Integer addSysUser(SysUser user) throws Exception;

    public Integer updateSysUser(SysUser user) throws Exception;

    public BaseResponse<PageResult<UserRequest>> queryuser(UserRequest userRequest) throws Exception;

}
