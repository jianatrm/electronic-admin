package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.WorkOrderVO;
import com.electronic.dao.mapper.bo.WorkOrder;

public interface WorkOrderService {

    public WorkOrder selectWorkOrder(WorkOrderVO workOrderVO) throws Exception;

    public Integer addWorkOrder(WorkOrderVO workOrderVO) throws Exception;

    public Integer updateWorkOrder(WorkOrderVO workOrderVO) throws Exception;

    public BaseResponse<PageResult<WorkOrderVO>> queryWorkOrder(WorkOrderVO workOrderVO) throws Exception;


    public BaseResponse<WorkOrderVO> queryWorkOrderDetail(WorkOrderVO workOrderVO) throws Exception;

    public BaseResponse approveWorkOrder(WorkOrderVO workOrderVO) throws Exception;

}
