package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.ElectronicDoc;
import com.electronic.dao.mapper.bo.ElectronicDocExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ElectronicDocMapper {
    int countByExample(ElectronicDocExample example);

    int deleteByExample(ElectronicDocExample example);

    int deleteByPrimaryKey(Integer docId);

    int insert(ElectronicDoc record);

    int insertSelective(ElectronicDoc record);

    List<ElectronicDoc> selectByExample(ElectronicDocExample example);

    ElectronicDoc selectByPrimaryKey(Integer docId);

    int updateByExampleSelective(@Param("record") ElectronicDoc record, @Param("example") ElectronicDocExample example);

    int updateByExample(@Param("record") ElectronicDoc record, @Param("example") ElectronicDocExample example);

    int updateByPrimaryKeySelective(ElectronicDoc record);

    int updateByPrimaryKey(ElectronicDoc record);
}
