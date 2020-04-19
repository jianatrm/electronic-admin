package com.electronic.service.impl;

import com.electronic.base.model.BaseResponse;
import com.electronic.base.model.PageResult;
import com.electronic.base.model.request.DeptRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.contants.UserConstants;
import com.electronic.dao.mapper.bo.SysDept;
import com.electronic.dao.mapper.bo.SysDeptExample;
import com.electronic.dao.mapper.interfaces.SysDeptMapper;
import com.electronic.service.SysDeptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysDeptServiceImpl implements SysDeptService {

    @Autowired
    SysDeptMapper sysDeptMapper;

    @Override
    public SysDept selectSysDept(SysDept Dept) throws Exception {
        SysDeptExample sysDeptExample = new SysDeptExample();
        SysDeptExample.Criteria criteria = sysDeptExample.createCriteria();
        if (!StringUtils.isBlank(Dept.getDeptName())){
            criteria.andDeptNameEqualTo(Dept.getDeptName());
        }
        List<SysDept> sysDepts = sysDeptMapper.selectByExample(sysDeptExample);
        return CollectionUtils.isEmpty(sysDepts)? null:sysDepts.get(0);
    }

    @Override
    public Integer addSysDept(SysDept Dept) throws Exception {
        Dept.setOperateTime(new Date());
        int insertSelective = sysDeptMapper.insertSelective(Dept);
        return insertSelective;
    }

    @Override
    public Integer updateSysDept(SysDept Dept) throws Exception {
        Dept.setOperateTime(new Date());
        int updateByPrimaryKeySelective = sysDeptMapper.updateByPrimaryKeySelective(Dept);
        return updateByPrimaryKeySelective;
    }

    @Override
    public BaseResponse<PageResult<SysDept>> queryDept(DeptRequest DeptRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);
        PageResult<SysDept> pageResult = new PageResult<>();
        SysDeptExample sysDeptExample = new SysDeptExample();
        SysDeptExample.Criteria criteria = sysDeptExample.createCriteria();
        if (!StringUtils.isEmpty(DeptRequest.getDeptName())){
            criteria.andDeptNameLike("%"+DeptRequest.getDeptName()+"%");
        }
        criteria.andStatusEqualTo(String.valueOf(UserConstants.VALID_STATUS));
        sysDeptExample.setOrderByClause("operate_time desc");
        PageHelper.startPage(DeptRequest.getPageNum(),DeptRequest.getPageSize());
        List<SysDept> sysDepts = sysDeptMapper.selectByExample(sysDeptExample);

        PageInfo pageInfo = new PageInfo(sysDepts);
        pageResult.setResult(sysDepts);
        pageResult.setPageCount(pageInfo.getPages());
        pageResult.setCount(pageInfo.getSize());
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}