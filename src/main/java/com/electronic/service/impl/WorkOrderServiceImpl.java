package com.electronic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.SessionUser;
import com.electronic.base.VO.WorkNodeVO;
import com.electronic.base.VO.WorkOrderVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.contants.NodeConstants;
import com.electronic.contants.UserConstants;
import com.electronic.contants.WorkOrderConstants;
import com.electronic.dao.mapper.bo.*;
import com.electronic.dao.mapper.interfaces.*;
import com.electronic.service.WorkOrderService;
import com.electronic.utils.SessionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    private WorkNodeMapper nodeMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private DeptElectronicDocMapper deptElectronicDocMapper;

    @Autowired
    private ElectronicDocMapper electronicDocMapper;

    @Override
    public WorkOrder selectWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        WorkOrderExample WorkOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = WorkOrderExample.createCriteria();
        if (workOrderVO.getWorkOrderId() > 0) {
            criteria.andWorkOrderIdEqualTo(workOrderVO.getWorkOrderId());
        }
        List<WorkOrder> WorkOrders = workOrderMapper.selectByExample(WorkOrderExample);
        return CollectionUtils.isEmpty(WorkOrders) ? null : WorkOrders.get(0);
    }

    @Override
    public Integer addWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        List<WorkNode> nodeList = JSONObject.parseArray(workOrderVO.getWorkNodeList(), WorkNode.class);
        WorkOrder workOrder = new WorkOrder();
        BeanUtils.copyProperties(workOrderVO, workOrder);
        workOrder.setWorkOrderStatus(WorkOrderConstants.APPROVAL);
        workOrder.setCurrentNode("1");
        workOrder.setNodeCount(nodeList.size());
        workOrder.setCreateTime(new Date());
        workOrder.setOperateTime(new Date());
        workOrder.setWorkOrderCode(DateFormatUtils.format(new Date(), "yyyyMMDDhhmmss"));
        workOrder.setWorkOrderName(workOrderVO.getWorkOrderName());
        workOrder.setWorkInfo(workOrderVO.getWorkInfo());
        int insertSelective = workOrderMapper.insertSelective(workOrder);


        for (int i = 0; i < nodeList.size(); i++) {
            WorkNode node = new WorkNode();
            BeanUtils.copyProperties(nodeList.get(i), node);
            if (i == 0){
                node.setNodeOperateStatus(NodeConstants.TO_OPERATE);
            }else {
                node.setNodeOperateStatus(NodeConstants.NO_OPERATE);
            }
            node.setWorkOrderId(workOrder.getWorkOrderId());
            nodeMapper.insert(node);
        }

        return insertSelective;
    }

    @Override
    public Integer updateWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderVO.getWorkOrderId());
//        workOrder.setCurrentWorkNode();
//        user.setOperateTime(new Date());
        int updateByPrimaryKeySelective = workOrderMapper.updateByPrimaryKeySelective(workOrder);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<WorkOrderVO>> queryWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS, BusinessConstants.BUSI_SUCCESS_CODE, BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<WorkOrderVO> pageResult = new PageResult<>();
        WorkOrderExample WorkOrderExample = new WorkOrderExample();
        WorkOrderExample.Criteria criteria = WorkOrderExample.createCriteria();
        criteria.andOrganizerEqualTo(workOrderVO.getOrganizer());
        if (workOrderVO.getWorkOrderStatus()>0){
            criteria.andWorkOrderStatusNotEqualTo(workOrderVO.getWorkOrderStatus());
        }
        WorkOrderExample.setOrderByClause("operate_time desc");
        PageHelper.startPage(workOrderVO.getPageNum(), workOrderVO.getPageSize());
        List<WorkOrder> workOrders = workOrderMapper.selectByExample(WorkOrderExample);
        List<WorkOrderVO> list = new ArrayList<>();
        for (WorkOrder workOrder : workOrders) {
            WorkOrderVO work = new WorkOrderVO();
            BeanUtils.copyProperties(workOrder, work);
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

    @Override
    public BaseResponse<WorkOrderVO> queryWorkOrderDetail(WorkOrderVO workOrderVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS, BusinessConstants.BUSI_SUCCESS_CODE, BusinessConstants.BUSI_SUCCESS_MESSAGE);
        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderVO.getWorkOrderId());
        if (workOrder ==null){
            return baseResponse;
        }
        WorkOrderVO orderVO = new WorkOrderVO();
        BeanUtils.copyProperties(workOrder,orderVO);
        WorkNodeExample workNodeExample = new WorkNodeExample();
        WorkNodeExample.Criteria criteria = workNodeExample.createCriteria();
        criteria.andWorkOrderIdEqualTo(workOrderVO.getWorkOrderId());
        List<WorkNode> workNodes = nodeMapper.selectByExample(workNodeExample);
        List<WorkNodeVO> workNodeVOList = new ArrayList<>();
        for (int i = 0; i <workNodes.size() ; i++) {
            WorkNodeVO workNodeVO = new WorkNodeVO();
            BeanUtils.copyProperties(workNodes.get(i),workNodeVO);
            Integer userId = workNodes.get(i).getUserId();
            SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
            workNodeVO.setUserName(sysUser.getUserName());
            workNodeVOList.add(workNodeVO);
        }
        criteria.andNodeOrderEqualTo(Integer.parseInt(workOrder.getCurrentNode()));
        List<WorkNode> currentWorkNode = nodeMapper.selectByExample(workNodeExample);
        if (!CollectionUtils.isEmpty(currentWorkNode)){
            WorkNode workNode = currentWorkNode.get(0);
            orderVO.setWorkNode(workNode);
        }
        orderVO.setWorkNodeList(JSONObject.toJSONString(workNodeVOList));
        baseResponse.setResult(orderVO);
        return baseResponse;
    }

    @Override
    public BaseResponse approveWorkOrder(WorkOrderVO workOrderVO) throws Exception {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS, BusinessConstants.BUSI_SUCCESS_CODE, BusinessConstants.BUSI_SUCCESS_MESSAGE);

        WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(workOrderVO.getWorkOrderId());
        WorkNode node = workOrderVO.getWorkNode();
        WorkNode workNode = nodeMapper.selectByPrimaryKey(node.getNodeId());

        Integer nodeCount = workOrder.getNodeCount();
        if (workNode.getNodeOrder()<nodeCount&&WorkOrderConstants.APPROVE_SUCCESS.equals(node.getNodeOperateResult())){
            workOrder.setCurrentNode(String.valueOf(Integer.parseInt(workOrderVO.getCurrentNode())+1));//更新当前节点为下一节点
        }

        workOrder.setOperateTime(new Date());




        //更新节点状态
        workNode.setNodeOperateStatus(NodeConstants.OPERATED);
        workNode.setNodeOperateResult(node.getNodeOperateResult());
        workNode.setNodeOperateDesc(node.getNodeOperateDesc());
        workNode.setNodeOperateTime(new Date());
        nodeMapper.updateByPrimaryKeySelective(workNode);


        //当前节点通过才会走下个节点
        if (workNode.getNodeOrder()<nodeCount&&WorkOrderConstants.APPROVE_SUCCESS.equals(node.getNodeOperateResult())){
            WorkNodeExample workNodeExample = new WorkNodeExample();
            WorkNodeExample.Criteria criteria = workNodeExample.createCriteria();
            criteria.andWorkOrderIdEqualTo(workOrderVO.getWorkOrderId());
            criteria.andNodeOrderEqualTo(workNode.getNodeOrder()+1);
            List<WorkNode> workNodes = nodeMapper.selectByExample(workNodeExample);
            if (!CollectionUtils.isEmpty(workNodes)){
                WorkNode workNode1 = workNodes.get(0);
                workNode1.setNodeOperateStatus(NodeConstants.TO_OPERATE);
                nodeMapper.updateByPrimaryKeySelective(workNode1);
            }
        }
        else if (workNode.getNodeOrder() == nodeCount&&WorkOrderConstants.APPROVE_SUCCESS.equals(node.getNodeOperateResult())){
            workOrder.setWorkOrderStatus(WorkOrderConstants.APPROVE_SUCCESS);
            SysDept sysDept = workOrderVO.getSysDept();
            if (!StringUtils.isBlank(workOrder.getWorkInfo())&&!"null".equals(workOrder.getWorkInfo())){
                List<ElectronicDoc> electronicDocs = JSONObject.parseArray(workOrder.getWorkInfo(), ElectronicDoc.class);
                for (int i = 0; i <electronicDocs.size() ; i++) {
                    ElectronicDoc electronicDoc = electronicDocs.get(i);
                    electronicDoc.setStatus(String.valueOf(UserConstants.VALID_STATUS));
                    electronicDoc.setOperateId(Integer.parseInt(workOrder.getOrganizer()));
                    electronicDocMapper.insertSelective(electronicDoc);
                    DeptElectronicDoc deptElectronicDoc = new DeptElectronicDoc();
                    deptElectronicDoc.setDeptId(sysDept.getDeptId());
                    deptElectronicDoc.setDocId(2);
                    deptElectronicDoc.setOperateId(Integer.parseInt(workOrder.getOrganizer()));
                    deptElectronicDoc.setOperateTime(new Date());
                    deptElectronicDoc.setStatus(UserConstants.VALID_STATUS);
                    deptElectronicDocMapper.insertSelective(deptElectronicDoc);
                }
            }
        }else {
            workOrder.setWorkOrderStatus(WorkOrderConstants.APPROVE_FIALE);
        }
        workOrderMapper.updateByPrimaryKeySelective(workOrder);
        return baseResponse;
    }
}
