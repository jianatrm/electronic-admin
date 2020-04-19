package com.electronic.base.model.request;

import com.electronic.dao.mapper.bo.Doc;
import com.electronic.dao.mapper.bo.Node;

import java.util.Date;
import java.util.List;

public class WorkOrderRequest {
    private Integer workOrderId;

    private String workOrderCode;

    private String workOrderName;

    private String workType;

    private String organizer;

    private String currentNode;

    private Integer nodeCount;

    private Date createTime;

    private Date operateTime;

    private Integer workOrderStatus;

    private String workInfo;

    private List<Node> nodeList;

    private List<Doc> doc;

    public List<Doc> getDoc() {
        return doc;
    }

    public void setDoc(List<Doc> doc) {
        this.doc = doc;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getWorkOrderCode() {
        return workOrderCode;
    }

    public void setWorkOrderCode(String workOrderCode) {
        this.workOrderCode = workOrderCode == null ? null : workOrderCode.trim();
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName == null ? null : workOrderName.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer == null ? null : organizer.trim();
    }

    public String getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(String currentNode) {
        this.currentNode = currentNode == null ? null : currentNode.trim();
    }

    public Integer getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(Integer nodeCount) {
        this.nodeCount = nodeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public Integer getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(Integer workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }

    public String getWorkInfo() {
        return workInfo;
    }

    public void setWorkInfo(String workInfo) {
        this.workInfo = workInfo == null ? null : workInfo.trim();
    }
}
