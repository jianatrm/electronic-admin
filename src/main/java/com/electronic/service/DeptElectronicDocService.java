package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.DeptElectronicDocVO;
import com.electronic.base.VO.SDeptElectronicDocVO;
import com.electronic.dao.mapper.bo.DeptElectronicDoc;

public interface DeptElectronicDocService {

    public DeptElectronicDoc selectDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception;

    public BaseResponse addDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception;

    public Integer updateDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception;

    public BaseResponse<PageResult<SDeptElectronicDocVO>> queryDeptElectronicDoc(SDeptElectronicDocVO sDeptElectronicDocVO) throws Exception;
}
