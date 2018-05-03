package com.zjy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.entity.Doctor;

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    public boolean updateByPrimaryKeySelective(Doctor doctor) {
        try{
        	if (doctorMapper.updateByPrimaryKeySelective(doctor) == 1) {
        		return true;
        	}
        }catch (Exception e) {
            throw new RuntimeException("更新医生失败");
        }
        return false;
    }

    public int deleteByPrimaryKey(String id) {
        try{
        	return doctorMapper.deleteByPrimaryKey(id);
        }catch (Exception e) {
            throw new RuntimeException("删除医生失败");
        }
    }

    public Doctor selectByDoctorNo(String id) {
        try {
            return doctorMapper.selectByDoctorNo(id);
        }catch(Exception e) {
            throw new RuntimeException("查看详情失败");
        }
    }
    
    public List<Doctor> selectDoctorByDepartment(String departmentNo) {
    	return doctorMapper.selectDoctorByDepartment(departmentNo);
    }

}