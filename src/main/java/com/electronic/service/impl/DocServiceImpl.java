package com.electronic.service.impl;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.DocRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.smapper.bo.SUserDoc;
import com.electronic.dao.smapper.interfaces.SUserDocMapper;
import com.electronic.service.DocService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {

    @Autowired
    DocMapper DocMapper;

    @Autowired
    SUserDocMapper sUserDocMapper;

    @Override
    public Doc selectDoc(Doc Dept) throws Exception {
        DocExample DocExample = new DocExample();
        DocExample.Criteria criteria = DocExample.createCriteria();
//        if (!StringUtils.isBlank(Dept.getDeptName())){
//            criteria.andDeptNameEqualTo(Dept.getDeptName());
//        }
        List<Doc> Docs = DocMapper.selectByExample(DocExample);
        return CollectionUtils.isEmpty(Docs)? null:Docs.get(0);
    }

    @Override
    public Integer addDoc(Doc doc) throws Exception {
        doc.setOperateTime(new Date());
        int insertSelective = DocMapper.insertSelective(doc);
        return insertSelective;
    }

    @Override
    public Integer updateDoc(Doc doc) throws Exception {
        doc.setOperateTime(new Date());
        int updateByPrimaryKeySelective = DocMapper.updateByPrimaryKeySelective(doc);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<SUserDoc>> queryDoc(DocRequest docRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<SUserDoc> pageResult = new PageResult<>();
//        if (!StringUtils.isEmpty(docRequest.getDocName())){
//            criteria.andDocNameLike("%"+docRequest.getDocName()+"%");
//        }
//        criteria.andStatusEqualTo(String.valueOf(UserConstants.VALID_STATUS));
        PageHelper.startPage(docRequest.getPageNum(),docRequest.getPageSize());
        List<SUserDoc> sUserDocs = sUserDocMapper.selectByUserId(1);

        PageInfo pageInfo = new PageInfo(sUserDocs);
        pageResult.setResult(sUserDocs);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
