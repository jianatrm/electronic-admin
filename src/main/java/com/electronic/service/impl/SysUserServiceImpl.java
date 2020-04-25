package com.electronic.service.impl;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.UserRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.SysDept;
import com.electronic.dao.mapper.bo.SysRoleUser;
import com.electronic.dao.mapper.bo.SysUser;
import com.electronic.dao.mapper.bo.SysUserExample;
import com.electronic.dao.mapper.interfaces.SysDeptMapper;
import com.electronic.dao.mapper.interfaces.SysRoleUserMapper;
import com.electronic.dao.mapper.interfaces.SysUserMapper;
import com.electronic.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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

    @Override
    public Integer addSysUser(SysUser user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(UserConstants.VALID_STATUS);
        user.setOperateTime(new Date());
        int insertSelective = sysUserMapper.insertSelective(user);
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setUserId(user.getUserId());
        sysRoleUser.setRoleId(Integer.parseInt(user.getLevel()));
        sysRoleUserMapper.insertSelective(sysRoleUser);
        return insertSelective;
    }

    @Override
    public Integer updateSysUser(SysUser user) throws Exception {
        String password = user.getPassword();
        if (!StringUtils.isBlank(password)){
            password = passwordEncoder.encode(password);
        }
        user.setPassword(password);
        user.setOperateTime(new Date());
        int updateByPrimaryKeySelective = sysUserMapper.updateByPrimaryKeySelective(user);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<UserRequest>> queryuser(UserRequest userRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<UserRequest> pageResult = new PageResult<>();
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
       // criteria.andStatusEqualTo(UserConstants.VALID_STATUS);
        if (!StringUtils.isEmpty(userRequest.getUserName())){
            criteria.andUserNameLike("%"+userRequest.getUserName()+"%");
        }
        sysUserExample.setOrderByClause("operate_time desc");
        PageHelper.startPage(userRequest.getPageNum(),userRequest.getPageSize());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        List<UserRequest> list = new ArrayList<>();

        for (SysUser sysUser:sysUsers){
            UserRequest request = new UserRequest();
            SysDept sysDept = sysDeptMapper.selectByPrimaryKey(sysUser.getDeptId());
            sysUser.setPassword("");
            BeanUtils.copyProperties(sysUser,request);
            request.setSysDept(sysDept);
            list.add(request);
        }
        PageInfo pageInfo = new PageInfo(sysUsers);
        pageResult.setResult(list);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
