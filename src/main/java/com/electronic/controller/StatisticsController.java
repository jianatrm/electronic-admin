package com.electronic.controller;

import com.alibaba.fastjson.JSONObject;
import com.electronic.base.BaseResponse;
import com.electronic.base.VO.SUserElectronicDocRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    public static final Logger LOGGER = LoggerFactory.getLogger(StatisticsController.class);

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping("/queryUserDoc")
    public BaseResponse queryUserDoc(@RequestBody SUserElectronicDocRequest sUserElectronicDocRequest) {
        LOGGER.info("统计查询，查询员工文档，{}", JSONObject.toJSONString(sUserElectronicDocRequest));
        BaseResponse baseResponse = new BaseResponse();
        try {
            baseResponse = statisticsService.queryUserDoc(sUserElectronicDocRequest);
            LOGGER.info("统计查询，查询员工文档结果，{}", JSONObject.toJSONString(baseResponse));
        } catch (Exception e) {
            LOGGER.info("统计查询，查询员工文档结果失败，{}", e.getMessage());
            baseResponse.setSuccess(false);
            baseResponse.setResultCode(BusinessConstants.BUSI_FAILURE_CODE);
            baseResponse.setResultMessage( e.getMessage());
        }
        return baseResponse;
    }

    @RequestMapping("/queryDeptDoc")
    public BaseResponse queryDeptDoc(@RequestBody SUserElectronicDocRequest sUserElectronicDocRequest) {
        LOGGER.info("统计查询，查询部门文档，{}", JSONObject.toJSONString(sUserElectronicDocRequest));
        BaseResponse baseResponse = null;
        try {
            baseResponse = statisticsService.queryDeptDoc(sUserElectronicDocRequest);
            LOGGER.info("统计查询，查询部门文档结果，{}", JSONObject.toJSONString(baseResponse));
        } catch (Exception e) {
            LOGGER.info("统计查询，查询部门文档结果失败，{}", e.getMessage());
            baseResponse.setSuccess(false);
            baseResponse.setResultCode(BusinessConstants.BUSI_FAILURE_CODE);
            baseResponse.setResultMessage( e.getMessage());
        }
        return baseResponse;
    }

}
