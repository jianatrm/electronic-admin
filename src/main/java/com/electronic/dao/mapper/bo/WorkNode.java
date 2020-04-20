package com.electronic.dao.mapper.bo;

import java.util.Date;

public class WorkNode {
    private Integer nodeId;

    private Integer workOrderId;

    private Integer userId;

    private Integer nodeOrder;

    private Integer nodeOperateStatus;

    private Date nodeOperateTime;

    private Integer nodeOperateResult;

    private String nodeOperateDesc;

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
        this.nodeOperateDesc = nodeOperateDesc == null ? null : nodeOperateDesc.trim();
    }
}