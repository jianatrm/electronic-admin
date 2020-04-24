package com.electronic.controller;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.SessionUser;
import com.electronic.base.VO.ElectronicDocRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.ElectronicDoc;
import com.electronic.dao.smapper.bo.SUserElectronicDoc;
import com.electronic.service.ElectronicDocService;
import com.electronic.utils.SessionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doc")
public class ElectronicDocController {

    public static  final Logger LOGGER = LoggerFactory.getLogger(ElectronicDocController.class);


    @Autowired
    private ElectronicDocService ElectronicDocService;

    /*
   查询ElectronicDoc
    */
    @RequestMapping("/queryElectronicDoc")
    public BaseResponse queryElectronicDoc(@RequestBody ElectronicDocRequest docRequest, Authentication authentication) throws Exception {
        SessionUser sessionUser = SessionUtils.getSessionUser();
        docRequest.setOperateId(sessionUser.getUserId());
        BaseResponse<PageResult<SUserElectronicDoc>> baseResponse = ElectronicDocService.queryElectronicDoc(docRequest);
        return baseResponse;
    }

    /*
    添加ElectronicDoc
     */
    @RequestMapping("addElectronicDoc")
    public BaseResponse addElectronicDoc(@RequestBody ElectronicDocRequest docRequest) throws Exception {
        String docList = docRequest.getElectronicDocList();
        if (StringUtils.isEmpty(docList)){
            return new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        }
        SessionUser sessionUser = SessionUtils.getSessionUser();
        docRequest.setOperateId(sessionUser.getUserId());
        BaseResponse baseResponse = ElectronicDocService.addElectronicDoc(docRequest);
        return baseResponse;
    }



    /*
   更新ElectronicDoc
    */
    @RequestMapping("updateElectronicDoc")
    public BaseResponse updateElectronicDoc(@RequestBody ElectronicDocRequest ElectronicDocRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        ElectronicDoc ElectronicDoc = new ElectronicDoc();
        BeanUtils.copyProperties(ElectronicDocRequest,ElectronicDoc);
        SessionUser sessionUser = SessionUtils.getSessionUser();
        ElectronicDoc.setOperateId(sessionUser.getUserId());
        Integer integer = ElectronicDocService.updateElectronicDoc(ElectronicDoc);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }

}
