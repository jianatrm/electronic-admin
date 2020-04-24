package com.electronic.service.impl;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.VO.DeptElectronicDocVO;
import com.electronic.base.VO.SDeptElectronicDocVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.DeptElectronicDoc;
import com.electronic.dao.mapper.bo.DeptElectronicDocExample;
import com.electronic.dao.mapper.interfaces.DeptElectronicDocMapper;
import com.electronic.dao.smapper.bo.SDeptElectronicDoc;
import com.electronic.dao.smapper.interfaces.SDeptElectronicDocMapper;
import com.electronic.service.DeptElectronicDocService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DeptElectronicDocServiceImpl implements DeptElectronicDocService {

    @Autowired
    private DeptElectronicDocMapper deptElectronicDocMapper;

    @Autowired
    private SDeptElectronicDocMapper sDeptElectronicDocMapper;


    @Override
    public DeptElectronicDoc selectDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception {
        DeptElectronicDocExample deptElectronicDocExample = new DeptElectronicDocExample();
        DeptElectronicDocExample.Criteria criteria = deptElectronicDocExample.createCriteria();
        criteria.andDeptIdEqualTo(deptElectronicDocVO.getDeptId());
        List<DeptElectronicDoc> deptElectronicDocs = deptElectronicDocMapper.selectByExample(deptElectronicDocExample);
        return null;
    }

    @Override
    public BaseResponse addDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception {
        return null;
    }

    @Override
    public Integer updateDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception {
        return null;
    }

    @Override
    public BaseResponse<PageResult<SDeptElectronicDocVO>> queryDeptElectronicDoc(SDeptElectronicDocVO sDeptElectronicDocVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<SDeptElectronicDocVO> pageResult = new PageResult<>();
        SDeptElectronicDoc sDeptElectronicDoc = new SDeptElectronicDoc();
        BeanUtils.copyProperties(sDeptElectronicDoc,sDeptElectronicDocVO);

        PageHelper.startPage(sDeptElectronicDocVO.getPageNum(),sDeptElectronicDocVO.getPageSize());
        List<SDeptElectronicDoc> deptElectronicDocs = sDeptElectronicDocMapper.selectByDeptId(sDeptElectronicDoc);
        PageInfo pageInfo = new PageInfo(deptElectronicDocs);


        List<SDeptElectronicDocVO> deptElectronicDocVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(deptElectronicDocs)){
            for (int i = 0; i <deptElectronicDocs.size() ; i++) {
                SDeptElectronicDocVO docVO = new SDeptElectronicDocVO();
                BeanUtils.copyProperties(docVO,deptElectronicDocs.get(i));
                deptElectronicDocVOList.add(docVO);
            }
        }
        pageResult.setResult(deptElectronicDocVOList);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
