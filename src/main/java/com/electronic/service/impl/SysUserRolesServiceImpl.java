package com.electronic.service.impl;

import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.dao.mapper.bo.SysUserRoles;
import com.electronic.dao.mapper.bo.SysUserRolesExample;
import com.electronic.dao.mapper.interfaces.SysUserRolesMapper;
import com.electronic.service.SysUserRolesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserRolesServiceImpl implements SysUserRolesService {
    @Autowired
    private SysUserRolesMapper sysUserRolesMapper;

    @Override
    public List<SysUserRoles> queryRoles(SysUser sysUser) {
        SysUserRolesExample sysUserRolesExample = new SysUserRolesExample();
        SysUserRolesExample.Criteria criteria = sysUserRolesExample.createCriteria();
        criteria.andUserIdEqualTo(sysUser.getUserid());
        criteria.andStatusEqualTo(UserConstants.VALID_STATUS);
        return sysUserRolesMapper.selectByExample(sysUserRolesExample);
    }
}
