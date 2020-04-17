package com.electronic.service.impl;

import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.*;
import com.electronic.dao.mapper.interfaces.SysRolesMapper;
import com.electronic.dao.mapper.interfaces.SysUserRolesMapper;
import com.electronic.service.UserAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserAndRoleServiceImpl implements UserAndRoleService {

    @Autowired
    private SysUserRolesMapper sysUserRolesMapper;

    @Autowired
    private SysRolesMapper sysRolesMapper;

    @Override
    public List<SysRoles> queryRolesByUser(SysUser sysUser) {
        SysUserRolesExample sysUserRolesExample = new SysUserRolesExample();
        SysUserRolesExample.Criteria criteria = sysUserRolesExample.createCriteria();
        criteria.andUserIdEqualTo(sysUser.getUserid());
        criteria.andStatusEqualTo(UserConstants.VALID_STATUS);
        List<SysUserRoles> sysUserRoles = sysUserRolesMapper.selectByExample(sysUserRolesExample);
        List<Integer> list = new ArrayList<>();
        for(SysUserRoles sysUserRole : sysUserRoles){
            list.add(sysUserRole.getRoleId());
        }
        SysRolesExample sysRolesExample = new SysRolesExample();
        SysRolesExample.Criteria sysRolesExampleCriteria = sysRolesExample.createCriteria();
        sysRolesExampleCriteria.andRoleIdIn(list);
        sysRolesExampleCriteria.andRoleStatusEqualTo(UserConstants.VALID_STATUS);
        return sysRolesMapper.selectByExample(sysRolesExample);
    }
}
