package com.electronic.service;

import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.dao.mapper.bo.SysUserRoles;

import java.util.List;

public interface SysUserRolesService {

    public List<SysUserRoles> queryRoles(SysUser sysUser);
}
