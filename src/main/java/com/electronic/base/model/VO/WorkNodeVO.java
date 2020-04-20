package com.electronic.base.model.VO;

import com.electronic.dao.mapper.bo.WorkOrder;

import java.util.Date;

public class WorkNodeVO {

    private Integer nodeId;

    private Integer workOrderId;

    private Integer userId;

    private Integer nodeOrder;

    private Integer nodeOperateStatus;

    private Date nodeOperateTime;

    private Integer nodeOperateResult;

    private String nodeOperateDesc;

    private WorkOrder workOrder;

    private Integer pageNum = 1;

    private Integer pageSize =10;

    private String userName;

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNodeOrder() {
        return nodeOrder;
    }

    public void setNodeOrder(Integer nodeOrder) {
        this.nodeOrder = nodeOrder;
    }

    public Integer getNodeOperateStatus() {
        return nodeOperateStatus;
    }

    public void setNodeOperateStatus(Integer nodeOperateStatus) {
        this.nodeOperateStatus = nodeOperateStatus;
    }

    public Date getNodeOperateTime() {
        return nodeOperateTime;
    }

    public void setNodeOperateTime(Date nodeOperateTime) {
        this.nodeOperateTime = nodeOperateTime;
    }

    public Integer getNodeOperateResult() {
        return nodeOperateResult;
    }

    public void setNodeOperateResult(Integer nodeOperateResult) {
        this.nodeOperateResult = nodeOperateResult;
    }

    public String getNodeOperateDesc() {
        return nodeOperateDesc;
    }

    public void setNodeOperateDesc(String nodeOperateDesc) {
        this.nodeOperateDesc = nodeOperateDesc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
