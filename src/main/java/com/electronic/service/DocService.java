package com.electronic.service;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.DeptRequest;
import com.electronic.base.model.request.DocRequest;
import com.electronic.dao.mapper.bo.Doc;
import com.electronic.dao.smapper.bo.SUserDoc;

public interface DocService {

    public Doc selectDoc(Doc doc) throws Exception;

    public Integer addDoc(Doc doc) throws Exception;

    public Integer updateDoc(Doc doc) throws Exception;

    public BaseResponse<PageResult<SUserDoc>> queryDoc(DocRequest docRequest) throws Exception;

}
