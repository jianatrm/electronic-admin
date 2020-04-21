package com.electronic.service.impl;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.VO.DeptElectronicDocVO;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.DeptElectronicDoc;
import com.electronic.dao.mapper.bo.DeptElectronicDocExample;
import com.electronic.dao.mapper.bo.ElectronicDoc;
import com.electronic.dao.mapper.interfaces.DeptElectronicDocMapper;
import com.electronic.dao.smapper.bo.SUserElectronicDoc;
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
    public BaseResponse<PageResult<DeptElectronicDocVO>> queryDeptElectronicDoc(DeptElectronicDocVO deptElectronicDocVO) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<DeptElectronicDocVO> pageResult = new PageResult<>();

        DeptElectronicDocExample deptElectronicDocExample = new DeptElectronicDocExample();
        DeptElectronicDocExample.Criteria criteria = deptElectronicDocExample.createCriteria();
        criteria.andDeptIdEqualTo(deptElectronicDocVO.getDeptId());
        PageHelper.startPage(deptElectronicDocVO.getPageNum(),deptElectronicDocVO.getPageSize());
        List<DeptElectronicDoc> deptElectronicDocs = deptElectronicDocMapper.selectByExample(deptElectronicDocExample);
        PageInfo pageInfo = new PageInfo(deptElectronicDocs);


        List<DeptElectronicDocVO> deptElectronicDocVOList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(deptElectronicDocs)){
            for (int i = 0; i <deptElectronicDocs.size() ; i++) {
                DeptElectronicDocVO docVO = new DeptElectronicDocVO();
                BeanUtils.copyProperties(deptElectronicDocs.get(i),docVO);
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
