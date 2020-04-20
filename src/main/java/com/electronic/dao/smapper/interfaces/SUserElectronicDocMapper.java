package com.electronic.dao.smapper.interfaces;

import com.electronic.dao.smapper.bo.SUserElectronicDoc;

import java.util.List;

public interface SUserElectronicDocMapper {

    List<SUserElectronicDoc> selectByUserId(Integer userId);
}
