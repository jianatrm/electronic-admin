package com.electronic.service;

import com.electronic.dao.mapper.bo.SysRole;
import com.electronic.dao.mapper.bo.SysUser;

import java.util.List;

public interface UserAndRoleService {

    public List<SysRole> queryRolesByUser (SysUser sysUser);

}
