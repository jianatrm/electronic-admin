package com.electronic.dao.smapper.bo;

import java.util.Date;

public class SDeptElectronicDoc {
    private Integer deptId;

    private String deptName;

    private Integer docId;

    private String docName;

    private String docUrl;

    private String docType;

    private String docRandomName;

    private String status;

    private String remark;

    private Integer operateId;

    private Date operateTime;

    private Integer count;

    private String months;

    private String startTime;

    private String endTime;

    private Integer startSize;

    private Integer pageSize;

    public String getDocRandomName() {
        return docRandomName;
    }

    public void setDocRandomName(String docRandomName) {
        this.docRandomName = docRandomName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDeptName() {
        return deptName;
    }



    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getStartSize() {
        return startSize;
    }

    public void setStartSize(Integer startSize) {
        this.startSize = startSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}
