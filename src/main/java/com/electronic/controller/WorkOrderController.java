package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.request.WorkOrderRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.service.WorkOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workOrder")
public class WorkOrderController {

    public static  final Logger LOGGER = LoggerFactory.getLogger(WorkOrderController.class);

    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping("/startWorkOrder")
    public BaseResponse startWorkOrder(@RequestBody WorkOrderRequest workOrderRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);

        Integer integer = workOrderService.addWorkOrder(workOrderRequest);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }

}
