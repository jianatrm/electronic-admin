package com.electronic.service.impl;

import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.*;
import com.electronic.service.UserAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserAndRoleServiceImpl implements UserAndRoleService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> queryRolesByUser(SysUser sysUser) {
        SysRoleUserExample SysRoleUserExample = new SysRoleUserExample();
        SysRoleUserExample.Criteria criteria = SysRoleUserExample.createCriteria();
        criteria.andUserIdEqualTo(sysUser.getUserId());
        List<SysRoleUser> sysUserRoles = sysRoleUserMapper.selectByExample(SysRoleUserExample);
        List<Integer> list = new ArrayList<>();
        for(SysRoleUser sysUserRole : sysUserRoles){
            list.add(sysUserRole.getRoleId());
        }
        SysRoleExample sysRolesExample = new SysRoleExample();
        SysRoleExample.Criteria sysRolesExampleCriteria = sysRolesExample.createCriteria();
        sysRolesExampleCriteria.andRoleidIn(list);
        sysRolesExampleCriteria.andStatusEqualTo(UserConstants.VALID_STATUS);
        return sysRoleMapper.selectByExample(sysRolesExample);
    }
}
