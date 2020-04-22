package com.electronic.dao.smapper.interfaces;

import com.electronic.dao.smapper.bo.SUserElectronicDoc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SUserElectronicDocMapper {

    List<SUserElectronicDoc> selectByUserId(@Param("userId") Integer userId,@Param("docName") String docName,@Param("startSize") Integer startSize,@Param("pageSize") Integer pageSize);
    Integer selectCountByUserId(@Param("userId") Integer userId,@Param("docName") String docName);

}
