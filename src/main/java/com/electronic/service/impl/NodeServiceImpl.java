package com.electronic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.NodeVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.Node;
import com.electronic.dao.mapper.bo.Node;
import com.electronic.dao.mapper.bo.NodeExample;
import com.electronic.dao.mapper.bo.WorkOrder;
import com.electronic.dao.mapper.interfaces.NodeMapper;
import com.electronic.dao.mapper.interfaces.NodeMapper;
import com.electronic.dao.mapper.interfaces.WorkOrderMapper;
import com.electronic.service.NodeService;
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
public class NodeServiceImpl implements NodeService {



    @Autowired
    private NodeMapper nodeMapper;

    @Autowired
    private WorkOrderMapper workOrderMapper;

    @Override
    public Node selectNode(NodeVO NodeVO) throws Exception {
        NodeExample NodeExample = new NodeExample();
        NodeExample.Criteria criteria = NodeExample.createCriteria();
        if (NodeVO.getNodeId()>0){
            criteria.andNodeIdEqualTo(NodeVO.getNodeId());
        }
        List<Node> Nodes = nodeMapper.selectByExample(NodeExample);
        return CollectionUtils.isEmpty(Nodes)? null:Nodes.get(0);
    }

    @Override
    public Integer addNode(NodeVO NodeVO) throws Exception {
//        List<Node> nodeList = JSONObject.parseArray(NodeVO.getNodeList(),Node.class);
//        Node Node = new Node();
//        BeanUtils.copyProperties(NodeVO,Node);
//        Node.setNodeStatus(NodeConstants.APPROVAL);
//        Node.setCurrentNode("1");
//        Node.setNodeCount(nodeList.size());
//        Node.setCreateTime(new Date());
//        Node.setOperateTime(new Date());
//        Node.setNodeCode(DateFormatUtils.format(new Date(),"yyyyMMDDhhmmss"));
//        Node.setNodeName(NodeVO.getNodeName());
//        Node.setWorkInfo(JSONObject.toJSONString(NodeVO.getDocList()));
//        int insertSelective = NodeMapper.insertSelective(Node);
//
//
//        for (int i = 0; i <nodeList.size() ; i++) {
//            Node node = new Node();
//            BeanUtils.copyProperties(nodeList.get(i),node);
//            node.setNodeStatus(NodeConstants.APPROVAL);
//            node.setNodeId(Node.getNodeId());
//            nodeMapper.insert(node);
//        }

        return 1;
    }

    @Override
    public Integer updateNode(NodeVO NodeVO) throws Exception {
//        Node Node = NodeMapper.selectByPrimaryKey(NodeVO.getNodeId());
////        Node.setCurrentNode();
////        user.setOperateTime(new Date());
//        int updateByPrimaryKeySelective = NodeMapper.updateByPrimaryKeySelective(Node);
        return 1;
    }

    @Override
    public BaseResponse<PageResult<NodeVO>> queryNode(NodeVO nodeVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<NodeVO> pageResult = new PageResult<>();
        NodeExample NodeExample = new NodeExample();
        NodeExample.Criteria criteria = NodeExample.createCriteria();
        criteria.andUserIdEqualTo(nodeVO.getUserId());
        criteria.andNodeStatusEqualTo(nodeVO.getNodeStatus());
        NodeExample.setOrderByClause(" node_id desc");
        PageHelper.startPage(nodeVO.getPageNum(),nodeVO.getPageSize());
        List<Node> Nodes = nodeMapper.selectByExample(NodeExample);
        List<NodeVO> list = new ArrayList<>();
        for (Node node:Nodes){
            NodeVO nodeVO1 = new NodeVO();
            BeanUtils.copyProperties(node,nodeVO1);
            WorkOrder workOrder = workOrderMapper.selectByPrimaryKey(nodeVO1.getWorkOrderId());
            nodeVO1.setWorkOrder(workOrder);
            list.add(nodeVO1);
        }
        PageInfo pageInfo = new PageInfo(Nodes);
        pageResult.setResult(list);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
