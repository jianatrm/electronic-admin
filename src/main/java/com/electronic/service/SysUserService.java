package com.electronic.service;

import com.electronic.dao.mapper.bo.SysUser;

public interface SysUserService {

    public SysUser selectSysUser(SysUser user) throws Exception;
}
