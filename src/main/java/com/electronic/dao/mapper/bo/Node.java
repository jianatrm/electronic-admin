package com.electronic.dao.mapper.bo;

public class Node {
    private Integer nodeId;

    private Integer workOrderId;

    private Integer userId;

    private Integer nodeOrder;

    private Integer nodeStatus;

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

    public Integer getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(Integer nodeStatus) {
        this.nodeStatus = nodeStatus;
    }
}