package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.NodeVO;
import com.electronic.base.model.VO.WorkOrderVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.WorkOrder;
import com.electronic.dao.mapper.interfaces.NodeMapper;
import com.electronic.service.NodeService;
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
    private NodeService nodeService;

    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping("/startWorkOrder")
    public BaseResponse startWorkOrder(@RequestBody WorkOrderVO workOrderVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        workOrderVO.setOrganizer("1");
        Integer integer = workOrderService.addWorkOrder(workOrderVO);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }

//    查询我的工单
    @RequestMapping("/queryWorkOrder")
    public BaseResponse queryWorkOrder(@RequestBody WorkOrderVO workOrderVO) throws Exception {
        workOrderVO.setOrganizer("1");
        BaseResponse<PageResult<WorkOrderVO>> pageResultBaseResponse = workOrderService.queryWorkOrder(workOrderVO);
        return pageResultBaseResponse;
    }

    //    查询待我审批工单
    @RequestMapping("/queryWorkOrderToMe")
    public BaseResponse queryWorkOrderToMe(@RequestBody NodeVO nodeVO) throws Exception {
        nodeVO.setUserId(1);
        BaseResponse<PageResult<NodeVO>> pageResultBaseResponse = nodeService.queryNode(nodeVO);
        return pageResultBaseResponse;
    }

}
