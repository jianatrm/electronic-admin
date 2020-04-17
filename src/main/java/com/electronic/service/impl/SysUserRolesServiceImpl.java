package com.electronic.service.impl;

import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.SysRoleUser;
import com.electronic.dao.mapper.bo.SysRoleUserExample;
import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.dao.mapper.interfaces.SysRoleUserMapper;
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
