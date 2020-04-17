package com.electronic.service;

import com.electronic.dao.mapper.bo.SysRoleUser;
import com.electronic.dao.mapper.bo.SysUser;

import java.util.List;

public interface SysUserRolesService {

    public List<SysRoleUser> queryRoles(SysUser sysUser);
}
