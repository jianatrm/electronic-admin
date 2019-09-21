package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.SysUserRoles;
import com.electronic.dao.mapper.bo.SysUserRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRolesMapper {
    long countByExample(SysUserRolesExample example);

    int deleteByExample(SysUserRolesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysUserRoles record);

    int insertSelective(SysUserRoles record);

    List<SysUserRoles> selectByExample(SysUserRolesExample example);

    SysUserRoles selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysUserRoles record, @Param("example") SysUserRolesExample example);

    int updateByExample(@Param("record") SysUserRoles record, @Param("example") SysUserRolesExample example);

    int updateByPrimaryKeySelective(SysUserRoles record);

    int updateByPrimaryKey(SysUserRoles record);
}