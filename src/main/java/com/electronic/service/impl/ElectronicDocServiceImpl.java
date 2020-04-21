package com.electronic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.ElectronicDocRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.ElectronicDoc;
import com.electronic.dao.mapper.bo.ElectronicDocExample;
import com.electronic.dao.mapper.bo.UserElectronicDoc;
import com.electronic.dao.mapper.interfaces.ElectronicDocMapper;
import com.electronic.dao.mapper.interfaces.UserElectronicDocMapper;
import com.electronic.dao.smapper.bo.SUserElectronicDoc;
import com.electronic.dao.smapper.interfaces.SUserElectronicDocMapper;
import com.electronic.service.ElectronicDocService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ElectronicDocServiceImpl implements ElectronicDocService {

    @Autowired
    ElectronicDocMapper docMapper;

    @Autowired
    private UserElectronicDocMapper userElectronicDocMapper;

    @Autowired
    SUserElectronicDocMapper sUserElectronicDocMapper;

    @Override
    public ElectronicDoc selectElectronicDoc(ElectronicDoc electronicDoc) throws Exception {
        ElectronicDocExample ElectronicDocExample = new ElectronicDocExample();
        ElectronicDocExample.Criteria criteria = ElectronicDocExample.createCriteria();
        if (electronicDoc.getOperateId()>0){
            criteria.andOperateIdEqualTo(electronicDoc.getOperateId());
        }
        List<ElectronicDoc> ElectronicDocs = docMapper.selectByExample(ElectronicDocExample);
        return CollectionUtils.isEmpty(ElectronicDocs)? null:ElectronicDocs.get(0);
    }

    @Override
    public BaseResponse addElectronicDoc(ElectronicDocRequest docRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);

        String docList = docRequest.getElectronicDocList();
        if (StringUtils.isEmpty(docList)){
            return new BaseResponse(BusinessConstants.BUSI_FAILURE,BusinessConstants.BUSI_FAILURE_CODE,BusinessConstants.BUSI_FAILURE_MESSAGE);
        }
        List<ElectronicDoc> docs = JSONObject.parseArray(docList, ElectronicDoc.class);
        for (ElectronicDoc doc:docs){
            doc.setOperateId(docRequest.getOperateId());
            doc.setOperateTime(new Date());
            docMapper.insertSelective(doc);
            UserElectronicDoc userElectronicDoc = new UserElectronicDoc();
            userElectronicDoc.setDocId(doc.getDocId());
            userElectronicDoc.setUserId(docRequest.getOperateId());
            userElectronicDoc.setOperateId(docRequest.getOperateId());
            userElectronicDoc.setOperateTime(new Date());
            userElectronicDocMapper.insert(userElectronicDoc);
        }
        return baseResponse;
    }

    @Override
    public Integer updateElectronicDoc(ElectronicDoc doc) throws Exception {
        doc.setOperateTime(new Date());
        int updateByPrimaryKeySelective = docMapper.updateByPrimaryKeySelective(doc);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<SUserElectronicDoc>> queryElectronicDoc(ElectronicDocRequest docRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<SUserElectronicDoc> pageResult = new PageResult<>();
        PageHelper.startPage(docRequest.getPageNum(),docRequest.getPageSize());
        List<SUserElectronicDoc> sUserElectronicDocs = sUserElectronicDocMapper.selectByUserId(docRequest.getOperateId());

        PageInfo pageInfo = new PageInfo(sUserElectronicDocs);
        pageResult.setResult(sUserElectronicDocs);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
