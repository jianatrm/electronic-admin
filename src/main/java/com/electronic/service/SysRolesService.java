package com.electronic.service;

import com.electronic.base.modle.BaseResponse;
import com.electronic.base.modle.PageResult;
import com.electronic.base.modle.request.RolesRequest;
import com.electronic.base.modle.response.RolesResponse;

public interface SysRolesService {

    public BaseResponse addRoles (RolesRequest rolesRequest) throws Exception;


    public BaseResponse<PageResult<RolesResponse>> selectSysRoles(RolesRequest rolesRequest) throws Exception;


    public BaseResponse updateSysRoles(RolesRequest rolesRequest) throws Exception;


    public BaseResponse deletetSysRoles(RolesRequest rolesRequest) throws Exception;
}
