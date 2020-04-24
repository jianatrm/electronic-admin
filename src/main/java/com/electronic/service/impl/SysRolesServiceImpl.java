package com.electronic.service.impl;

import com.alibaba.fastjson.JSON;
import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.RolesRequest;
import com.electronic.base.response.RolesResponse;
import com.electronic.contants.BusinessConstants;
import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.SysRole;
import com.electronic.dao.mapper.bo.SysRoleExample;
import com.electronic.dao.mapper.interfaces.SysRoleMapper;
import com.electronic.service.SysRolesService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SysRolesServiceImpl implements SysRolesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysRolesServiceImpl.class);
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public BaseResponse addRoles(RolesRequest rolesRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        Assert.isNull(rolesRequest,"rolesRequest新增参数不能为空");
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("新增请求参数 {} ", JSON.toJSONString(rolesRequest));
        }
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(rolesRequest,sysRole);
        sysRole.setOperateTime(new Date());
        sysRole.setStatus(UserConstants.VALID_STATUS);
        int i = sysRoleMapper.insertSelective(sysRole);
        if (i>0){
            baseResponse.setSuccess(BusinessConstants.BUSI_SUCCESS);
            baseResponse.setResultCode(BusinessConstants.BUSI_SUCCESS_CODE);
            baseResponse.setResultMessage(BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }


        return baseResponse;
    }

    @Override
    public BaseResponse<PageResult<RolesResponse>> selectSysRoles(RolesRequest rolesRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult pageResult = new PageResult();
        Assert.isNull(rolesRequest,"rolesRequest查询参数不能为空");
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("查询请求参数 {} ", JSON.toJSONString(rolesRequest));
        }
        SysRoleExample SysRoleExample = new SysRoleExample();
        SysRoleExample.Criteria criteria = SysRoleExample.createCriteria();
        if (rolesRequest.getRoleId()!=0&&rolesRequest.getRoleId()!=null){
            criteria.andRoleIdEqualTo(rolesRequest.getRoleId());
        }
        if (!StringUtils.isBlank(rolesRequest.getRoleName())){
            criteria.andRoleNameEqualTo(rolesRequest.getRoleName());
        }
        long count = sysRoleMapper.countByExample(SysRoleExample);
        if (!StringUtils.isBlank(rolesRequest.getPageNo())&&!StringUtils.isBlank(rolesRequest.getPageSize())){
            PageHelper.startPage(Integer.valueOf(rolesRequest.getPageNo()),Integer.valueOf(rolesRequest.getPageSize()));
        }
        List<SysRole> sysRoles = sysRoleMapper.selectByExample(SysRoleExample);
        pageResult.setResult(sysRoles);
        pageResult.setCount(count);
        baseResponse.setResult(pageResult);
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("查询请求结果 {} ", JSON.toJSONString(sysRoles));
        }
        return baseResponse;
    }

    @Override
    public BaseResponse updateSysRoles(RolesRequest rolesRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        Assert.isNull(rolesRequest.getRoleId(),"更新请求参数ID不能为空");
        if (LOGGER.isDebugEnabled()){
            LOGGER.debug("更新请求参数 {} ", JSON.toJSONString(rolesRequest));
        }
        return null;
    }

    @Override
    public BaseResponse deletetSysRoles(RolesRequest rolesRequest) throws Exception {
        return null;
    }
}
