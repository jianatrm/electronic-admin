package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.SessionUser;
import com.electronic.base.VO.SUserElectronicDocRequest;

public interface StatisticsService {

    public BaseResponse userInfo(SessionUser sessionUser) throws Exception;


    public BaseResponse selectCountByMonth(String year) throws Exception;

    public BaseResponse queryUserDoc(SUserElectronicDocRequest sUserElectronicDocRequest) throws Exception;

    public BaseResponse queryDeptDoc(SUserElectronicDocRequest sUserElectronicDocRequest) throws Exception;


}
