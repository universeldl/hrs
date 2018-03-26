package com.zjy.entity;

import java.util.Calendar;
import java.util.Date;

import com.zjy.util.Constants;
import com.zjy.util.IdGenerator;

public class Patient {
    private String id;

    private String patientNo;

    private String patientName;

    private String patientPassword;

    private String patientSalt;

    private String patientSex;

    private Date patientBirth;

    private String patientPhone;

    private String isDeleted;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = IdGenerator.generateUUIDforPrimaryKey();
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo() {
    	Calendar calendar = Calendar.getInstance();
		String datePrefix = "";
		datePrefix += calendar.get(Calendar.YEAR);
		datePrefix += String.format("%02d", calendar.get(Calendar.MONTH)+1);
		datePrefix += String.format("%02d", calendar.get(Calendar.DATE));
		datePrefix = datePrefix.substring(2);
        this.patientNo = IdGenerator.generateNumber(datePrefix, Constants.PATIENT_NO_DIGITS);
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword == null ? null : patientPassword.trim();
    }

    public String getPatientSalt() {
        return patientSalt;
    }

    public void setPatientSalt(String patientSalt) {
        this.patientSalt = patientSalt == null ? null : patientSalt.trim();
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex == null ? null : patientSex.trim();
    }

    public Date getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(Date patientBirth) {
        this.patientBirth = patientBirth;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone == null ? null : patientPhone.trim();
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