package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.SessionUser;
import com.electronic.base.model.VO.DeptElectronicDocVO;
import com.electronic.base.model.VO.SDeptElectronicDocVO;
import com.electronic.dao.mapper.interfaces.DeptElectronicDocMapper;
import com.electronic.service.DeptElectronicDocService;
import com.electronic.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deptElectronicDoc")
public class DeptElectronicDocController {

    @Autowired
    private DeptElectronicDocService deptElectronicDocService;

    @RequestMapping("/queryDeptElectronicDoc")
    public BaseResponse queryDeptElectronicDoc(@RequestBody SDeptElectronicDocVO deptElectronicDocVO) throws Exception {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        deptElectronicDocVO.setDeptId(sessionUser.getDeptId());
        BaseResponse<PageResult<SDeptElectronicDocVO>> pageResultBaseResponse = deptElectronicDocService.queryDeptElectronicDoc(deptElectronicDocVO);
        return pageResultBaseResponse;
    }
}
