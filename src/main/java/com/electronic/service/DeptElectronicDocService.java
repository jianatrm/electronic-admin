package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.DeptElectronicDocVO;
import com.electronic.base.model.VO.ElectronicDocRequest;
import com.electronic.base.model.VO.SDeptElectronicDocVO;
import com.electronic.dao.mapper.bo.DeptElectronicDoc;
import com.electronic.dao.mapper.bo.ElectronicDoc;
import com.electronic.dao.smapper.bo.SUserElectronicDoc;

public interface DeptElectronicDocService {

    public DeptElectronicDoc selectDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception;

    public BaseResponse addDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception;

    public Integer updateDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception;

    public BaseResponse<PageResult<SDeptElectronicDocVO>> queryDeptElectronicDoc(SDeptElectronicDocVO sDeptElectronicDocVO) throws Exception;
}
