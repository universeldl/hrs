package com.zjy.dao;

import java.util.UUID;

public class Duty {
    private String id;
    private String docId;
    private String dutyTime;
    private String isChecked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(String dutyTime) {
        this.dutyTime = dutyTime;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }

}
