package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.WorkOrderRequest;
import com.electronic.dao.mapper.bo.WorkOrder;

public interface WorkOrderService {

    public WorkOrder selectWorkOrder(WorkOrderRequest workOrderRequest) throws Exception;

    public Integer addWorkOrder(WorkOrderRequest workOrderRequest) throws Exception;

    public Integer updateWorkOrder(WorkOrderRequest workOrderRequest) throws Exception;

    public BaseResponse<PageResult<WorkOrder>> queryWorkOrder(WorkOrderRequest workOrderRequest) throws Exception;

}
