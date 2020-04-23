package com.electronic.dao.smapper.interfaces;

import com.electronic.dao.smapper.bo.SDeptMonthDoc;

import java.util.List;

public interface SDeptMonthDocMapper {


    List<SDeptMonthDoc> selectCountByMonth(String year);
}
