package com.electronic.service.impl;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.WorkNodeVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.WorkNode;
import com.electronic.dao.mapper.bo.WorkNodeExample;
import com.electronic.dao.mapper.bo.WorkOrder;
import com.electronic.dao.mapper.interfaces.WorkNodeMapper;
import com.electronic.dao.mapper.interfaces.WorkOrderMapper;
import com.electronic.service.WorkNodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class WorkNodeServiceImpl implements WorkNodeService {



    @Autowired
    private WorkNodeMapper nodeMapper;

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Override
    public WorkNode selectWorkNode(WorkNodeVO WorkNodeVO) throws Exception {
        WorkNodeExample WorkNodeExample = new WorkNodeExample();
        WorkNodeExample.Criteria criteria = WorkNodeExample.createCriteria();
        if (WorkNodeVO.getNodeId()>0){
            criteria.andNodeIdEqualTo(WorkNodeVO.getNodeId());
        }
        List<WorkNode> WorkNodes = nodeMapper.selectByExample(WorkNodeExample);
        return CollectionUtils.isEmpty(WorkNodes)? null:WorkNodes.get(0);
    }

    @Override
    public Integer addWorkNode(WorkNodeVO WorkNodeVO) throws Exception {
//        List<WorkNode> nodeList = JSONObject.parseArray(WorkNodeVO.getWorkNodeList(),WorkNode.class);
//        WorkNode WorkNode = new WorkNode();
//        BeanUtils.copyProperties(WorkNodeVO,WorkNode);
//        WorkNode.setWorkNodeStatus(WorkNodeConstants.APPROVAL);
//        WorkNode.setCurrentWorkNode("1");
//        WorkNode.setWorkNodeCount(nodeList.size());
//        WorkNode.setCreateTime(new Date());
//        WorkNode.setOperateTime(new Date());
//        WorkNode.setWorkNodeCode(DateFormatUtils.format(new Date(),"yyyyMMDDhhmmss"));
//        WorkNode.setWorkNodeName(WorkNodeVO.getWorkNodeName());
//        WorkNode.setWorkInfo(JSONObject.toJSONString(WorkNodeVO.getDocList()));
//        int insertSelective = WorkNodeMapper.insertSelective(WorkNode);
//
//
//        for (int i = 0; i <nodeList.size() ; i++) {
//            WorkNode node = new WorkNode();
//            BeanUtils.copyProperties(nodeList.get(i),node);
//            node.setWorkNodeStatus(WorkNodeConstants.APPROVAL);
//            node.setWorkNodeId(WorkNode.getWorkNodeId());
//            nodeMapper.insert(node);
//        }

        return 1;
    }

    @Override
    public Integer updateWorkNode(WorkNodeVO WorkNodeVO) throws Exception {
//        WorkNode WorkNode = WorkNodeMapper.selectByPrimaryKey(WorkNodeVO.getWorkNodeId());
////        WorkNode.setCurrentWorkNode();
////        user.setOperateTime(new Date());
//        int updateByPrimaryKeySelective = WorkNodeMapper.updateByPrimaryKeySelective(WorkNode);
        return 1;
    }

    @Override
    public BaseResponse<PageResult<WorkNodeVO>> queryWorkNode(WorkNodeVO nodeVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<WorkNodeVO> pageResult = new PageResult<>();
        WorkNodeExample WorkNodeExample = new WorkNodeExample();
        WorkNodeExample.Criteria criteria = WorkNodeExample.createCriteria();
        criteria.andUserIdEqualTo(nodeVO.getUserId());
        criteria.andNodeOperateStatusEqualTo(nodeVO.getNodeOperateStatus());
        WorkNodeExample.setOrderByClause(" node_id desc");
        PageHelper.startPage(nodeVO.getPageNum(),nodeVO.getPageSize());
        List<WorkNode> WorkNodes = nodeMapper.selectByExample(WorkNodeExample);
        List<WorkNodeVO> list = new ArrayList<>();
        for (WorkNode node:WorkNodes){
            WorkNodeVO nodeVO1 = new WorkNodeVO();
            BeanUtils.copyProperties(node,nodeVO1);
            WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(nodeVO1.getWorkOrderId());
            nodeVO1.setWorkOrder(workOrder);
            list.add(nodeVO1);
        }
        PageInfo pageInfo = new PageInfo(WorkNodes);
        pageResult.setResult(list);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
