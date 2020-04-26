package com.electronic.base.VO;

import com.electronic.dao.mapper.bo.ElectronicDoc;

import java.util.Date;

public class DeptElectronicDocVO {

    private Integer id;

    private Integer deptId;

    private Integer docId;

    private Integer workOrderId;

    private Integer operateId;

    private Date operateTime;

    private Integer status;

    private Integer pageNum = 1;

    private Integer pageSize =10;

    private ElectronicDoc electronicDoc;

    public Integer getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(Integer workOrderId) {
        this.workOrderId = workOrderId;
    }

    public ElectronicDoc getElectronicDoc() {
        return electronicDoc;
    }

    public void setElectronicDoc(ElectronicDoc electronicDoc) {
        this.electronicDoc = electronicDoc;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
