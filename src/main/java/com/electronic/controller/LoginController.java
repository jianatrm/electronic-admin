package com.electronic.controller;

import com.electronic.base.BaseResponse;
import com.electronic.base.SessionUser;
import com.electronic.service.StatisticsService;
import com.electronic.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/userInfo")
    public BaseResponse userInfo() throws Exception {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        BaseResponse baseResponse = statisticsService.userInfo(sessionUser);
        return baseResponse;

    }
    @RequestMapping("/selectCountByMonth")
    public BaseResponse deptMonthDoc(HttpServletRequest request) throws Exception {
        String year = request.getParameter("year");
        BaseResponse baseResponse = statisticsService.selectCountByMonth(year);
        return baseResponse;

    }



}
