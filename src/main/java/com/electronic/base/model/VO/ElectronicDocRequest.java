package com.electronic.base.model.VO;

public class ElectronicDocRequest {
    private Integer userId;

    private Integer docId;

    private String docName;

    private String electronicDocList;

    private Integer pageNum = 1;
    private Integer pageSize =10;
    public String getElectronicDocList() {
        return electronicDocList;
    }

    public void setElectronicDocList(String electronicDocList) {
        this.electronicDocList = electronicDocList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        this.docName = docName == null ? null : docName.trim();
    }


}
