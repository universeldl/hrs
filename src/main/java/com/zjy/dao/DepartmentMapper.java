package com.zjy.dao;

import java.util.List;

import com.zjy.entity.Department;

public interface DepartmentMapper {
    int deleteByDeptNo(String departmentNo);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);

    Department selectByDeptNo(String departmentNo);
    
    List<Department> selectPageListByName(Department departmentName);

    int updateByNo(String departmentNo, String depName);
}