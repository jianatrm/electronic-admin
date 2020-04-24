package com.electronic.base.VO;

import com.electronic.dao.mapper.bo.SysDept;
import com.electronic.dao.mapper.bo.WorkNode;

import java.util.Date;

public class WorkOrderVO {

    private Integer workOrderId;

    private String workOrderCode;

    private String workOrderName;

    private String workType;

    private String organizer;

    private String currentNode;

    private Integer nodeCount;

    private Date createTime;

    private Date operateTime;

    private Integer workOrderStatus =0;

    private String workOrderStatusDesc;

    private String workInfo;

    private String workNodeList;

    private WorkNode workNode;

    private SysDept sysDept;

    private String docList;

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    public SysDept getSysDept() {
        return sysDept;
    }

    public void setSysDept(SysDept sysDept) {
        this.sysDept = sysDept;
    }

    public WorkNode getWorkNode() {
        return workNode;
    }

    public void setWorkNode(WorkNode workNode) {
        this.workNode = workNode;
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

    public String getWorkOrderStatusDesc() {
        return workOrderStatusDesc;
    }

    public void setWorkOrderStatusDesc(String workOrderStatusDesc) {
        this.workOrderStatusDesc = workOrderStatusDesc;
    }

    public String getWorkNodeList() {
        return workNodeList;
    }

    public void setWorkNodeList(String workNodeList) {
        this.workNodeList = workNodeList;
    }

    public String getDocList() {
        return docList;
    }

    public void setDocList(String docList) {
        this.docList = docList;
    }

    private String workOrderDesc;

    public String getWorkOrderDesc() {
        return workOrderDesc;
    }

    public void setWorkOrderDesc(String workOrderDesc) {
        this.workOrderDesc = workOrderDesc;
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
