package com.zjy.dao;

import java.util.List;

import com.zjy.entity.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);

    void addPrescriptions(List<Prescription> list);
}