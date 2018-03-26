package com.zjy.dao;

import com.zjy.entity.Visit;

public interface VisitMapper {
    int deleteByPrimaryKey(String id);

    int insert(Visit record);

    int insertSelective(Visit record);

    Visit selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Visit record);

    int updateByPrimaryKeyWithBLOBs(Visit record);

    int updateByPrimaryKey(Visit record);
}