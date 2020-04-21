package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.SessionUser;
import com.electronic.base.model.VO.WorkNodeVO;
import com.electronic.base.model.VO.WorkOrderVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.service.WorkNodeService;
import com.electronic.service.WorkOrderService;
import com.electronic.utils.SessionUtils;
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
    private WorkNodeService nodeService;

    @Autowired
    private WorkOrderService workOrderService;

    @RequestMapping("/startWorkOrder")
    public BaseResponse startWorkOrder(@RequestBody WorkOrderVO workOrderVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        SessionUser sessionUser = SessionUtils.getSessionUser();
        workOrderVO.setOrganizer(String.valueOf(sessionUser.getUserId()));
        Integer integer = workOrderService.addWorkOrder(workOrderVO);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }

//    查询我的工单
    @RequestMapping("/queryWorkOrder")
    public BaseResponse queryWorkOrder(@RequestBody WorkOrderVO workOrderVO) throws Exception {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        workOrderVO.setOrganizer(String.valueOf(sessionUser.getUserId()));
        BaseResponse<PageResult<WorkOrderVO>> pageResultBaseResponse = workOrderService.queryWorkOrder(workOrderVO);
        return pageResultBaseResponse;
    }

    //    查询待我审批工单
    @RequestMapping("/queryWorkOrderToMe")
    public BaseResponse queryWorkOrderToMe(@RequestBody WorkNodeVO nodeVO) throws Exception {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        nodeVO.setUserId(sessionUser.getUserId());
        BaseResponse<PageResult<WorkNodeVO>> pageResultBaseResponse = nodeService.queryWorkNode(nodeVO);
        return pageResultBaseResponse;
    }
    /*查看工单详情？*/
    @RequestMapping("/queryWorkOrderDetail")
    public BaseResponse queryWorkOrderDetail(@RequestBody WorkOrderVO workOrderVO) throws Exception {
        BaseResponse<WorkOrderVO> workOrderVOBaseResponse = workOrderService.queryWorkOrderDetail(workOrderVO);
        return workOrderVOBaseResponse;
    }


    /*审批工单？*/
    @RequestMapping("/approveWorkOrder")
    public BaseResponse approveWorkOrder(@RequestBody WorkOrderVO workOrderVO) throws Exception {

        BaseResponse workOrderVOBaseResponse = workOrderService.approveWorkOrder(workOrderVO);
        return workOrderVOBaseResponse;
    }

}
