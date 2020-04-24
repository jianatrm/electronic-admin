package com.electronic.controller;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.SessionUser;
import com.electronic.base.VO.SDeptElectronicDocVO;
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
