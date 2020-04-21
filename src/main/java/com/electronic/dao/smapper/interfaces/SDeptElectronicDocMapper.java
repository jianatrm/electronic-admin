package com.electronic.dao.smapper.interfaces;

import com.electronic.dao.smapper.bo.SDeptElectronicDoc;

import java.util.List;

public interface SDeptElectronicDocMapper {

    List<SDeptElectronicDoc> selectByDeptId(SDeptElectronicDoc sDeptElectronicDoc);
}
