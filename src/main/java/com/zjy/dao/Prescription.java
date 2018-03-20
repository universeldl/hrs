package com.zjy.dao;

import java.util.UUID;

public class Prescription {
    private String id;
    private String registerId;
    private String drugsId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getDrugsId() {
        return drugsId;
    }

    public void setDrugsId(String drugsId) {
        this.drugsId = drugsId;
    }

}
