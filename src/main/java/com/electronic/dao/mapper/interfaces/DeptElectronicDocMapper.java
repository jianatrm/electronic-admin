package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.DeptElectronicDoc;
import com.electronic.dao.mapper.bo.DeptElectronicDocExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptElectronicDocMapper {
    int countByExample(DeptElectronicDocExample example);

    int deleteByExample(DeptElectronicDocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeptElectronicDoc record);

    int insertSelective(DeptElectronicDoc record);

    List<DeptElectronicDoc> selectByExample(DeptElectronicDocExample example);

    DeptElectronicDoc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeptElectronicDoc record, @Param("example") DeptElectronicDocExample example);

    int updateByExample(@Param("record") DeptElectronicDoc record, @Param("example") DeptElectronicDocExample example);

    int updateByPrimaryKeySelective(DeptElectronicDoc record);

    int updateByPrimaryKey(DeptElectronicDoc record);
}
