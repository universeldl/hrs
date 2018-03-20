package com.zjy.dao;

import org.apache.ibatis.annotations.Param;

public interface DoctorMapper {

    Doctor queryDoctor(String id);

}
