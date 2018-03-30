package com.zjy.dao;

import com.zjy.entity.Registration;

public interface RegistrationMapper {
    int deleteByPrimaryKey(String id);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);

    Registration selectRegistrationByNo(String regNo);
}