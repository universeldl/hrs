package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.entity.Doctor;

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    
    public boolean insert(Doctor doctor) {
        /**
         * 处理密码，密码盐
         * 入职日期和离职日期，前端接收date类型，在这里转string类型的YYYY-MM-DD格式后set
         */
        try{
        	if (doctorMapper.insert(doctor) == 1)
        		return true;
        }catch (Exception e) {
            throw new RuntimeException("插入医生失败");
        }
		return false;
    }

    public boolean updateByPrimaryKeySelective(Doctor doctor) {
        try{
        	if (doctorMapper.updateByPrimaryKeySelective(doctor) == 1)
        		return true;
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

}