package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.DocRequest;
import com.electronic.dao.mapper.bo.Doc;
import com.electronic.dao.smapper.bo.SUserDoc;

import java.util.List;

public interface DocService {

    public Doc selectDoc(Doc doc) throws Exception;

    public BaseResponse addDoc( List<Doc> docList) throws Exception;

    public Integer updateDoc(Doc doc) throws Exception;

    public BaseResponse<PageResult<SUserDoc>> queryDoc(DocRequest docRequest) throws Exception;

}
