package com.electronic.service;

import java.util.List;

public interface UserAndRoleService {

    public List<SysRole> queryRolesByUser (SysUser sysUser);

}
