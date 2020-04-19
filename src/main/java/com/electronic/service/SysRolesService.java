package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.RolesRequest;
import com.electronic.base.model.response.RolesResponse;

public interface SysRolesService {

    public BaseResponse addRoles (RolesRequest rolesRequest) throws Exception;


    public BaseResponse<PageResult<RolesResponse>> selectSysRoles(RolesRequest rolesRequest) throws Exception;


    public BaseResponse updateSysRoles(RolesRequest rolesRequest) throws Exception;


    public BaseResponse deletetSysRoles(RolesRequest rolesRequest) throws Exception;
}
