package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.DeptRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.service.SysDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {

    public static  final Logger LOGGER = LoggerFactory.getLogger(DeptController.class);


    @Autowired
    private SysDeptService sysDeptService;

    /*
   查询Dept
    */
    @RequestMapping("/queryDept")
    public BaseResponse queryDept(@RequestBody DeptRequest DeptRequest) throws Exception {
        BaseResponse<PageResult<SysDept>> baseResponse = sysDeptService.queryDept(DeptRequest);
        return baseResponse;
    }

    /*
    添加Dept
     */
    @RequestMapping("addDept")
    public BaseResponse addDept(@RequestBody DeptRequest DeptRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(DeptRequest,sysDept);

        Integer integer = sysDeptService.addSysDept(sysDept);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }



    /*
   更新Dept
    */
    @RequestMapping("updateDept")
    public BaseResponse updateDept(@RequestBody DeptRequest DeptRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(DeptRequest,sysDept);
        Integer integer = sysDeptService.updateSysDept(sysDept);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }
}
