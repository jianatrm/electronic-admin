package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.UserElectronicDoc;
import com.electronic.dao.mapper.bo.UserElectronicDocExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserElectronicDocMapper {
    int countByExample(UserElectronicDocExample example);

    int deleteByExample(UserElectronicDocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserElectronicDoc record);

    int insertSelective(UserElectronicDoc record);

    List<UserElectronicDoc> selectByExample(UserElectronicDocExample example);

    UserElectronicDoc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserElectronicDoc record, @Param("example") UserElectronicDocExample example);

    int updateByExample(@Param("record") UserElectronicDoc record, @Param("example") UserElectronicDocExample example);

    int updateByPrimaryKeySelective(UserElectronicDoc record);

    int updateByPrimaryKey(UserElectronicDoc record);
}
