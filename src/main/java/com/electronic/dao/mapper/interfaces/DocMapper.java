package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.Doc;
import com.electronic.dao.mapper.bo.DocExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocMapper {
    int countByExample(DocExample example);

    int deleteByExample(DocExample example);

    int deleteByPrimaryKey(Integer docId);

    int insert(Doc record);

    int insertSelective(Doc record);

    List<Doc> selectByExample(DocExample example);

    Doc selectByPrimaryKey(Integer docId);

    int updateByExampleSelective(@Param("record") Doc record, @Param("example") DocExample example);

    int updateByExample(@Param("record") Doc record, @Param("example") DocExample example);

    int updateByPrimaryKeySelective(Doc record);

    int updateByPrimaryKey(Doc record);
}
