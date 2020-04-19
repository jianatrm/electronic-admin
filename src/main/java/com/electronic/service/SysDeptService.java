package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.DeptRequest;
import com.electronic.dao.mapper.bo.SysDept;

public interface SysDeptService {

    public SysDept selectSysDept(SysDept Dept) throws Exception;

    public Integer addSysDept(SysDept Dept) throws Exception;

    public Integer updateSysDept(SysDept Dept) throws Exception;

    public BaseResponse<PageResult<SysDept>> queryDept(DeptRequest DeptRequest) throws Exception;

}
