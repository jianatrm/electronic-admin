package com.electronic.service;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.WorkNodeVO;
import com.electronic.dao.mapper.bo.WorkNode;

public interface WorkNodeService {

    public WorkNode selectWorkNode(WorkNodeVO WorkNodeVO) throws Exception;

    public Integer addWorkNode(WorkNodeVO WorkNodeVO) throws Exception;

    public Integer updateWorkNode(WorkNodeVO WorkNodeVO) throws Exception;

    public BaseResponse<PageResult<WorkNodeVO>> queryWorkNode(WorkNodeVO nodeVO) throws Exception;

}
