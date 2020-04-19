package com.electronic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.UserRequest;
import com.electronic.base.model.request.WorkOrderRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.contants.UserConstants;
import com.electronic.contants.WorkOrderConstants;
import com.electronic.dao.mapper.bo.Node;
import com.electronic.dao.mapper.bo.WorkOrder;
import com.electronic.dao.mapper.bo.WorkOrderExample;
import com.electronic.dao.mapper.interfaces.NodeMapper;
import com.electronic.dao.mapper.interfaces.WorkOrderMapper;
import com.electronic.service.WorkOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateParser;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Autowired
    private NodeMapper nodeMapper;

    @Override
    public WorkOrder selectWorkOrder(WorkOrderRequest workOrderRequest) throws Exception {
        WorkOrderExample WorkOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = WorkOrderExample.createCriteria();
        if (workOrderRequest.getWorkOrderId()>0){
            criteria.andWorkOrderIdEqualTo(workOrderRequest.getWorkOrderId());
        }
        List<WorkOrder> WorkOrders = workOrderMapper.selectByExample(WorkOrderExample);
        return CollectionUtils.isEmpty(WorkOrders)? null:WorkOrders.get(0);
    }

    @Override
    public Integer addWorkOrder(WorkOrderRequest workOrderRequest) throws Exception {
        List<Node> nodeList = workOrderRequest.getNodeList();
        WorkOrder workOrder = new WorkOrder();
        BeanUtils.copyProperties(workOrderRequest,workOrder);
        workOrder.setWorkOrderStatus(WorkOrderConstants.APPROVAL);
        workOrder.setCurrentNode("1");
        workOrder.setNodeCount(nodeList.size());
        workOrder.setCreateTime(new Date());
        workOrder.setOperateTime(new Date());
        workOrder.setWorkOrderCode(DateFormatUtils.format(new Date(),"yyyyMMDDhhmmss"));
        workOrder.setWorkOrderName(workOrderRequest.getWorkOrderName());
        workOrder.setWorkInfo(JSONObject.toJSONString(workOrderRequest.getDoc()));
        int insertSelective = workOrderMapper.insertSelective(workOrder);


        for (int i = 0; i <nodeList.size() ; i++) {
            nodeList.get(i).setWorkOrderId(workOrder.getWorkOrderId());
            nodeMapper.insert(nodeList.get(i));
        }

        return insertSelective;
    }

    @Override
    public Integer updateWorkOrder(WorkOrderRequest workOrderRequest) throws Exception {
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderRequest.getWorkOrderId());
//        workOrder.setCurrentNode();
//        user.setOperateTime(new Date());
        int updateByPrimaryKeySelective = workOrderMapper.updateByPrimaryKeySelective(workOrder);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<WorkOrder>> queryWorkOrder(WorkOrderRequest workOrderRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<WorkOrder> pageResult = new PageResult<>();
        WorkOrderExample WorkOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = WorkOrderExample.createCriteria();
//        criteria.andStatusEqualTo(UserConstants.VALID_STATUS);
//        if (!StringUtils.isEmpty(userRequest.getUserName())){
//            criteria.andUserNameLike("%"+userRequest.getUserName()+"%");
//        }
        WorkOrderExample.setOrderByClause("operate_time desc");
        //PageHelper.startPage(userRequest.getPageNum(),userRequest.getPageSize());
        List<WorkOrder> workOrders = workOrderMapper.selectByExample(WorkOrderExample);
        for (WorkOrder workOrder:workOrders){
        }
        PageInfo pageInfo = new PageInfo(workOrders);
        pageResult.setResult(workOrders);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
