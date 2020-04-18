package com.electronic.service.impl;

import com.electronic.base.model.BaseResponse;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.smapper.bo.SysMenuRoles;
import com.electronic.dao.smapper.interfaces.SysMenuMapper;
import com.electronic.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public BaseResponse queryMenuAndRoles() throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        List<SysMenuRoles> sysMenuRoles = sysMenuMapper.selectSysMenuRoles();
        for(SysMenuRoles sysmenuRole : sysMenuRoles){
            if (!StringUtils.isBlank(sysmenuRole.getRoleId())){
                List<String> roles = Arrays.asList(StringUtils.split(sysmenuRole.getRoleId(), ","));
                sysmenuRole.setRoleIds(roles);
                List<String> rolenames = Arrays.asList(StringUtils.split(sysmenuRole.getRoleName(), ","));
                sysmenuRole.setRoleNames(rolenames);
            }

        }
        baseResponse.setResult(sysMenuRoles);
        return baseResponse;
    }
}
