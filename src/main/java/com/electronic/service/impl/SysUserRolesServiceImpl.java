package com.electronic.service.impl;

import com.electronic.service.SysUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserRolesServiceImpl implements SysUserRolesService {
    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Override
    public List<SysRoleUser> queryRoles(SysUser sysUser) {
        SysRoleUserExample sysUserRolesExample = new SysRoleUserExample();
        SysRoleUserExample.Criteria criteria = sysUserRolesExample.createCriteria();
        criteria.andUserIdEqualTo(sysUser.getUserId());
        return sysRoleUserMapper.selectByExample(sysUserRolesExample);
    }
}
