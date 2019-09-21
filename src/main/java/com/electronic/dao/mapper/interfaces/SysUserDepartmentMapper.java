package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.SysUserDepartment;
import com.electronic.dao.mapper.bo.SysUserDepartmentExample;
import com.electronic.dao.mapper.bo.SysUserDepartmentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserDepartmentMapper {
    long countByExample(SysUserDepartmentExample example);

    int deleteByExample(SysUserDepartmentExample example);

    int deleteByPrimaryKey(SysUserDepartmentKey key);

    int insert(SysUserDepartment record);

    int insertSelective(SysUserDepartment record);

    List<SysUserDepartment> selectByExample(SysUserDepartmentExample example);

    SysUserDepartment selectByPrimaryKey(SysUserDepartmentKey key);

    int updateByExampleSelective(@Param("record") SysUserDepartment record, @Param("example") SysUserDepartmentExample example);

    int updateByExample(@Param("record") SysUserDepartment record, @Param("example") SysUserDepartmentExample example);

    int updateByPrimaryKeySelective(SysUserDepartment record);

    int updateByPrimaryKey(SysUserDepartment record);
}