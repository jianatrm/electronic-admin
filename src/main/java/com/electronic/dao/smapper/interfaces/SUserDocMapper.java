package com.electronic.dao.smapper.interfaces;

import com.electronic.dao.smapper.bo.SUserDoc;
import com.electronic.dao.smapper.bo.SysMenuRoles;

import java.util.List;

public interface SUserDocMapper {

    List<SUserDoc> selectByUserId(Integer userId);
}
