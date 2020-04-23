package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.SessionUser;

public interface StatisticsService {

    public BaseResponse userInfo(SessionUser sessionUser) throws Exception;


    public BaseResponse selectCountByMonth(String year) throws Exception;


}
