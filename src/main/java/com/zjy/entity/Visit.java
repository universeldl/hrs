package com.zjy.entity;

import java.util.Calendar;
import java.util.Date;

import com.zjy.util.Constants;
import com.zjy.util.IdGenerator;

public class Visit {
    private String id;

    private String registrationNo;

    private String patientNo;

    private String departmentNo;

    private String doctorNo;

    private Date appointmentTime;

    private Date visitTime;

    private String status;

    private Date createTime;

    private Date updateTime;

    private String diagnosticDescription;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setId(){
    	this.id = IdGenerator.generateUUIDforPrimaryKey();
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo == null ? null : patientNo.trim();
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo == null ? null : departmentNo.trim();
    }

    public String getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(String doctorNo) {
        this.doctorNo = doctorNo == null ? null : doctorNo.trim();
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Constants.VISIT_TYPE;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime() {
        this.createTime = Calendar.getInstance().getTime();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime() {
        this.updateTime = Calendar.getInstance().getTime();
    }

    public String getDiagnosticDescription() {
        return diagnosticDescription;
    }

    public void setDiagnosticDescription(String diagnosticDescription) {
        this.diagnosticDescription = diagnosticDescription == null ? null : diagnosticDescription.trim();
    }
}