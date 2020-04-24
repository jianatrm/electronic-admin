package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.ElectronicDocRequest;
import com.electronic.dao.mapper.bo.ElectronicDoc;
import com.electronic.dao.smapper.bo.SUserElectronicDoc;

public interface ElectronicDocService {

    public ElectronicDoc selectElectronicDoc(ElectronicDoc doc) throws Exception;

    public BaseResponse addElectronicDoc( ElectronicDocRequest docRequest) throws Exception;

    public Integer updateElectronicDoc(ElectronicDoc doc) throws Exception;

    public BaseResponse<PageResult<SUserElectronicDoc>> queryElectronicDoc(ElectronicDocRequest docRequest) throws Exception;

}
