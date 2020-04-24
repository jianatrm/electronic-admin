package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.RolesRequest;
import com.electronic.base.response.RolesResponse;

public interface SysRolesService {

    public BaseResponse addRoles (RolesRequest rolesRequest) throws Exception;


    public BaseResponse<PageResult<RolesResponse>> selectSysRoles(RolesRequest rolesRequest) throws Exception;


    public BaseResponse updateSysRoles(RolesRequest rolesRequest) throws Exception;


    public BaseResponse deletetSysRoles(RolesRequest rolesRequest) throws Exception;
}
