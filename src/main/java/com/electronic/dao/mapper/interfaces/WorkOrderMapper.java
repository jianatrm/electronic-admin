package com.electronic.dao.mapper.interfaces;

import com.electronic.dao.mapper.bo.WorkOrder;
import com.electronic.dao.mapper.bo.WorkOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkOrderMapper {
    int countByExample(WorkOrderExample example);

    int deleteByExample(WorkOrderExample example);

    int deleteByPrimaryKey(Integer workOrderId);

    int insert(WorkOrder record);

    int insertSelective(WorkOrder record);

    List<WorkOrder> selectByExampleWithBLOBs(WorkOrderExample example);

    List<WorkOrder> selectByExample(WorkOrderExample example);

    WorkOrder selectByPrimaryKey(Integer workOrderId);

    int updateByExampleSelective(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByExample(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByPrimaryKeySelective(WorkOrder record);

    int updateByPrimaryKeyWithBLOBs(WorkOrder record);

    int updateByPrimaryKey(WorkOrder record);
}
