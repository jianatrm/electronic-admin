package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.NodeVO;
import com.electronic.dao.mapper.bo.Node;

public interface NodeService {

    public Node selectNode(NodeVO NodeVO) throws Exception;

    public Integer addNode(NodeVO NodeVO) throws Exception;

    public Integer updateNode(NodeVO NodeVO) throws Exception;

    public BaseResponse<PageResult<NodeVO>> queryNode(NodeVO nodeVO) throws Exception;

}
