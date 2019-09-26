package com.electronic.service;

import com.electronic.base.modle.BaseResponse;
import com.electronic.dao.mapper.bo.SysRoles;
import com.electronic.dao.mapper.bo.SysUser;

import java.util.List;

public interface UserAndRoleService {

    public List<SysRoles> queryRolesByUser (SysUser sysUser);

}
