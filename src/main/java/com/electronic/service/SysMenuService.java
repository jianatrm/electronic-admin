package com.electronic.service;

import com.electronic.base.modle.BaseResponse;

public interface SysMenuService {

    //系统初始化时获取每个菜单对应拥有的角色
    public BaseResponse queryMenuAndRoles() throws Exception;
}
