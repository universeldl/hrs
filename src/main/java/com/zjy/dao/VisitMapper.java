package com.zjy.dao;

import com.zjy.entity.Registration;
import com.zjy.entity.Visit;

public interface VisitMapper {
    int deleteByPrimaryKey(String id);

    int insert(Registration registration);

    int insertSelective(Visit record);

    Visit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKeyWithBLOBs(Visit record);

    int updateByPrimaryKey(Visit record);

    int updateDiagnostic(String patientNo, String diagnostic);
}