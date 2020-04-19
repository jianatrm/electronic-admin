package com.electronic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.WorkOrderVO;
import com.electronic.contants.BusinessConstants;
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
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public WorkOrder selectWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        WorkOrderExample WorkOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = WorkOrderExample.createCriteria();
        if (workOrderVO.getWorkOrderId()>0){
            criteria.andWorkOrderIdEqualTo(workOrderVO.getWorkOrderId());
        }
        List<WorkOrder> WorkOrders = workOrderMapper.selectByExample(WorkOrderExample);
        return CollectionUtils.isEmpty(WorkOrders)? null:WorkOrders.get(0);
    }

    @Override
    public Integer addWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        List<Node> nodeList = JSONObject.parseArray(workOrderVO.getNodeList(),Node.class);
        WorkOrder workOrder = new WorkOrder();
        BeanUtils.copyProperties(workOrderVO,workOrder);
        workOrder.setWorkOrderStatus(WorkOrderConstants.APPROVAL);
        workOrder.setCurrentNode("1");
        workOrder.setNodeCount(nodeList.size());
        workOrder.setCreateTime(new Date());
        workOrder.setOperateTime(new Date());
        workOrder.setWorkOrderCode(DateFormatUtils.format(new Date(),"yyyyMMDDhhmmss"));
        workOrder.setWorkOrderName(workOrderVO.getWorkOrderName());
        workOrder.setWorkInfo(JSONObject.toJSONString(workOrderVO.getDocList()));
        int insertSelective = workOrderMapper.insertSelective(workOrder);


        for (int i = 0; i <nodeList.size() ; i++) {
            Node node = new Node();
            BeanUtils.copyProperties(nodeList.get(i),node);
            node.setNodeStatus(WorkOrderConstants.APPROVAL);
            node.setWorkOrderId(workOrder.getWorkOrderId());
            nodeMapper.insert(node);
        }

        return insertSelective;
    }

    @Override
    public Integer updateWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderVO.getWorkOrderId());
//        workOrder.setCurrentNode();
//        user.setOperateTime(new Date());
        int updateByPrimaryKeySelective = workOrderMapper.updateByPrimaryKeySelective(workOrder);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<WorkOrderVO>> queryWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<WorkOrderVO> pageResult = new PageResult<>();
        WorkOrderExample WorkOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = WorkOrderExample.createCriteria();
        criteria.andOrganizerEqualTo(workOrderVO.getOrganizer());
        WorkOrderExample.setOrderByClause("operate_time desc");
        PageHelper.startPage(workOrderVO.getPageNum(),workOrderVO.getPageSize());
        List<WorkOrder> workOrders = workOrderMapper.selectByExample(WorkOrderExample);
        List<WorkOrderVO> list = new ArrayList<>();
        for (WorkOrder workOrder:workOrders){
            WorkOrderVO work = new WorkOrderVO();
            BeanUtils.copyProperties(workOrder,work);
            work.setWorkOrderStatusDesc(WorkOrderConstants.getStatus(workOrder.getWorkOrderStatus()));
            list.add(work);
        }
        PageInfo pageInfo = new PageInfo(workOrders);
        pageResult.setResult(list);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
