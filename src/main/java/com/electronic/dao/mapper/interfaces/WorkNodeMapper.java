package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.WorkNode;
import com.electronic.dao.mapper.bo.WorkNodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkNodeMapper {
    int countByExample(WorkNodeExample example);

    int deleteByExample(WorkNodeExample example);

    int deleteByPrimaryKey(Integer nodeId);

    int insert(WorkNode record);

    int insertSelective(WorkNode record);

    List<WorkNode> selectByExample(WorkNodeExample example);

    WorkNode selectByPrimaryKey(Integer nodeId);

    int updateByExampleSelective(@Param("record") WorkNode record, @Param("example") WorkNodeExample example);

    int updateByExample(@Param("record") WorkNode record, @Param("example") WorkNodeExample example);

    int updateByPrimaryKeySelective(WorkNode record);

    int updateByPrimaryKey(WorkNode record);
}
