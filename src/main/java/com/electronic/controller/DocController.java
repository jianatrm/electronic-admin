package com.electronic.controller;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.SessionUser;
import com.electronic.base.model.request.DocRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.Doc;
import com.electronic.dao.smapper.bo.SUserDoc;
import com.electronic.service.DocService;
import com.electronic.utils.SessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doc")
public class DocController {

    public static  final Logger LOGGER = LoggerFactory.getLogger(DocController.class);


    @Autowired
    private DocService DocService;

    /*
   查询Doc
    */
    @RequestMapping("/queryDoc")
    public BaseResponse queryDoc(@RequestBody DocRequest docRequest, Authentication authentication) throws Exception {
//        SessionUser sessionUser = SessionUtils.getSessionUser();
        BaseResponse<PageResult<SUserDoc>> baseResponse = DocService.queryDoc(docRequest);
        return baseResponse;
    }

    /*
    添加Doc
     */
    @RequestMapping("addDoc")
    public BaseResponse addDoc(@RequestBody DocRequest DocRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        Doc Doc = new Doc();
        BeanUtils.copyProperties(DocRequest,Doc);

        Integer integer = DocService.addDoc(Doc);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }



    /*
   更新Doc
    */
    @RequestMapping("updateDoc")
    public BaseResponse updateDoc(@RequestBody DocRequest DocRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        Doc Doc = new Doc();
        BeanUtils.copyProperties(DocRequest,Doc);
        Integer integer = DocService.updateDoc(Doc);
        if (integer>0){
            baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        }
        return baseResponse;
    }

}
