package com.zjy.entity;

import java.util.Date;
import java.util.Random;

import com.zjy.util.Constants;
import com.zjy.util.IdGenerator;

public class Department {
    private String id;

    private String departmentNo;

    private String departmentName;

    private String isDeleted;

    private Date createTime;

    private Date updateTime;
    
    private Random random;

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = IdGenerator.generateUUIDforPrimaryKey();
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo() {
        this.departmentNo = IdGenerator.generateNumber(Constants.DEPARTMENT_NO_PREFIX, Constants.DOCTOR_NO_DIGITS);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}