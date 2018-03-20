package com.zjy.dao;

import java.util.UUID;

public class Drugs {
    private String id;
    private String drugsNo;
    private String drugsName;
    private double price;
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public String getDrugsNo() {
        return drugsNo;
    }

    public void setDrugsNo(String drugsNo) {
        this.drugsNo = drugsNo;
    }

    public String getDrugsName() {
        return drugsName;
    }

    public void setDrugsName(String drugsName) {
        this.drugsName = drugsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
