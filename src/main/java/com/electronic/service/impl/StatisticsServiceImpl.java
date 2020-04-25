package com.electronic.service.impl;

import com.electronic.base.BaseResponse;
import com.electronic.base.PageResult;
import com.electronic.base.SessionUser;
import com.electronic.base.VO.SUserElectronicDocRequest;
import com.electronic.contants.BusinessConstants;
import com.electronic.dao.mapper.bo.*;
import com.electronic.dao.mapper.interfaces.*;
import com.electronic.dao.smapper.bo.SDeptElectronicDoc;
import com.electronic.dao.smapper.bo.SDeptMonthDoc;
import com.electronic.dao.smapper.bo.SUserElectronicDoc;
import com.electronic.dao.smapper.interfaces.SDeptElectronicDocMapper;
import com.electronic.dao.smapper.interfaces.SDeptMonthDocMapper;
import com.electronic.dao.smapper.interfaces.SUserElectronicDocMapper;
import com.electronic.service.StatisticsService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private SUserElectronicDocMapper sUserElectronicDocMapper;

    @Autowired
    private SDeptElectronicDocMapper sDeptElectronicDocMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SDeptMonthDocMapper sDeptMonthDocMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;

    @Autowired
    private UserElectronicDocMapper userElectronicDocMapper;

    @Autowired
    private DeptElectronicDocMapper deptElectronicDocMapper;

    @Override
    public BaseResponse userInfo(SessionUser sessionUser) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);

        Integer userId = sessionUser.getUserId();
        Integer deptId = sessionUser.getDeptId();
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        SysDept sysDept = sysDeptMapper.selectByPrimaryKey(deptId);
        SysDept company = sysDeptMapper.selectByPrimaryKey(1);

        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        SysRoleUserExample.Criteria criteria = sysRoleUserExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<SysRoleUser> sysRoleUsers = sysRoleUserMapper.selectByExample(sysRoleUserExample);
        List<SysRole> sysRoleList = new ArrayList<>();
        for (int i = 0; i <sysRoleUsers.size() ; i++) {
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(sysRoleUsers.get(i).getRoleId());
            sysRoleList.add(sysRole);
        }


        //用户文档数量
       // Integer userCount = sUserElectronicDocMapper.selectCountByUserId(userId, null);
        UserElectronicDocExample userElectronicDocExample = new UserElectronicDocExample();
        UserElectronicDocExample.Criteria userElectronicDocExampleCriteria = userElectronicDocExample.createCriteria();
        userElectronicDocExampleCriteria.andUserIdEqualTo(userId);
        int userCount = userElectronicDocMapper.countByExample(userElectronicDocExample);

        DeptElectronicDocExample deptElectronicDocExample = new DeptElectronicDocExample();
        DeptElectronicDocExample.Criteria deptElectronicDocExampleCriteria = deptElectronicDocExample.createCriteria();
        //公司文档数量
        int companyCount = deptElectronicDocMapper.countByExample(deptElectronicDocExample);
        deptElectronicDocExampleCriteria.andDeptIdEqualTo(deptId);
        //部门文档数量
        int deptCount = deptElectronicDocMapper.countByExample(deptElectronicDocExample);

        //用户文档分类
        List<SUserElectronicDoc> sUserElectronicDocs = sUserElectronicDocMapper.selectDocTypeCountByUserId(userId);


        Map<String,Object> map = new HashMap<>();
        map.put("userName",sysUser.getUserName());
        map.put("userAvatar",sysUser.getUserAvatar());
        map.put("userEmail",sysUser.getUserEmail());
        map.put("userPhone",sysUser.getUserPhone());
        map.put("nickName",sysUser.getNickName());
        map.put("userId",sysUser.getUserId());
        if (null != sysDept) {
            map.put("deptName", sysDept.getDeptName());
        }
        if (null != company){
            map.put("companyName",company.getDeptName());
        }
        map.put("sysRoleList",sysRoleList);
        map.put("companyCount",companyCount);
        map.put("deptCount",deptCount);
        map.put("userCount",userCount);
        map.put("sUserElectronicDocs",sUserElectronicDocs);
        baseResponse.setResult(map);
        return baseResponse;
    }

    @Override
    public BaseResponse selectCountByMonth(String year) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);

        List<SDeptMonthDoc> sDeptMonthDocs = sDeptMonthDocMapper.selectCountByMonth(year);
        baseResponse.setResult(sDeptMonthDocs);
        return baseResponse;
    }

    @Override
    public BaseResponse queryUserDoc(SUserElectronicDocRequest sUserElectronicDocRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);

        PageResult<SUserElectronicDoc> pageResult = new PageResult<>();

        Integer userId = sUserElectronicDocRequest.getUserId();
        String docName = sUserElectronicDocRequest.getDocName();
        String startTime = sUserElectronicDocRequest.getStartTime();
        String endTime = sUserElectronicDocRequest.getEndTime();
        Integer pageSize = sUserElectronicDocRequest.getPageSize();
        Integer startSize = (sUserElectronicDocRequest.getPageNum()-1)* pageSize;

        List<SUserElectronicDoc> sUserElectronicDocs = sUserElectronicDocMapper.selectByUserId(userId, docName, startTime, endTime, startSize, pageSize);
        Integer integer = sUserElectronicDocMapper.selectCountByUserId(userId, docName, startTime, endTime);
        if (!CollectionUtils.isEmpty(sUserElectronicDocs)){
            for (int i = 0; i <sUserElectronicDocs.size() ; i++) {
                Integer userId1 = sUserElectronicDocs.get(i).getUserId();
                SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId1);
                sUserElectronicDocs.get(i).setUserName(sysUser==null?"":sysUser.getUserName());
            }
        }
        pageResult.setResult(sUserElectronicDocs);
        pageResult.setCount(integer);
        baseResponse.setResult(pageResult);
        return baseResponse;
    }

    @Override
    public BaseResponse queryDeptDoc(SUserElectronicDocRequest sUserElectronicDocRequest) throws Exception {
        BaseResponse baseResponse = new BaseResponse(BusinessConstants.BUSI_SUCCESS,BusinessConstants.BUSI_SUCCESS_CODE,BusinessConstants.BUSI_SUCCESS_MESSAGE);

        PageResult<SDeptElectronicDoc> pageResult = new PageResult<>();

        Integer pageSize = sUserElectronicDocRequest.getPageSize();
        Integer startSize = (sUserElectronicDocRequest.getPageNum()-1)* pageSize;

        SDeptElectronicDoc sDeptElectronicDoc = new SDeptElectronicDoc();
        BeanUtils.copyProperties(sUserElectronicDocRequest,sDeptElectronicDoc);
        sDeptElectronicDoc.setPageSize(pageSize);
        sDeptElectronicDoc.setStartSize(startSize);
        Integer integer = sDeptElectronicDocMapper.selectCountByDeptId(sDeptElectronicDoc);
        List<SDeptElectronicDoc> sDeptElectronicDocs = sDeptElectronicDocMapper.selectByDeptId(sDeptElectronicDoc);
        if (!CollectionUtils.isEmpty(sDeptElectronicDocs)){
            for (int i = 0; i <sDeptElectronicDocs.size() ; i++) {
                Integer deptId1 = sDeptElectronicDocs.get(i).getDeptId();
                SysDept sysDept = sysDeptMapper.selectByPrimaryKey(deptId1);
                sDeptElectronicDocs.get(i).setDeptName(sysDept==null?"":sysDept.getDeptName());
            }
        }

        pageResult.setResult(sDeptElectronicDocs);
        pageResult.setCount(integer);
        baseResponse.setResult(pageResult);
        return baseResponse;
    }
}
