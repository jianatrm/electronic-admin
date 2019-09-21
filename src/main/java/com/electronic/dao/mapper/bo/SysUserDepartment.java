package com.electronic.dao.mapper.bo;

import java.util.Date;

public class SysUserDepartment extends SysUserDepartmentKey {
    private String status;

    private Date creattime;

    private Date modifytime;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}