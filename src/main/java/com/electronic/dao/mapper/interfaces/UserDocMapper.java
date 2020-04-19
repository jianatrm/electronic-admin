package com.electronic.dao.mapper.interfaces;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDocMapper {
    int countByExample(UserDocExample example);

    int deleteByExample(UserDocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserDoc record);

    int insertSelective(UserDoc record);

    List<UserDoc> selectByExample(UserDocExample example);

    UserDoc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserDoc record, @Param("example") UserDocExample example);

    int updateByExample(@Param("record") UserDoc record, @Param("example") UserDocExample example);

    int updateByPrimaryKeySelective(UserDoc record);

    int updateByPrimaryKey(UserDoc record);
}
