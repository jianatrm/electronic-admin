package com.electronic.service.impl;

import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.dao.mapper.bo.SysUserExample;
import com.electronic.dao.mapper.interfaces.SysUserMapper;
import com.electronic.service.SysUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectSysUser(SysUser user) throws Exception {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        if (!StringUtils.isBlank(user.getUserName())){
            criteria.andUserNameEqualTo(user.getUserName());
        }
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        return CollectionUtils.isEmpty(sysUsers)? null:sysUsers.get(0);
    }
}
