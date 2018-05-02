package com.zjy.dao;

import java.util.List;
import java.util.Map;

import com.zjy.entity.Department;
import com.zjy.entity.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);

    Doctor selectByDoctorNo(String id);

    List<Doctor> queryDoctor(Map<String, Object> param);

    List<Doctor> queryDoctorByDepNo(String depNo);

    int selectCountByDeptNo(String departmentNo);
    
    int count(Map<String, Object> param);

    int deleteByDoctorNo(String doctorNo);
}