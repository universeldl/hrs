package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.AdminMapper;
import com.zjy.dao.Doctor;

@Service
public class DoctorManagermentService {

    @Autowired
    private AdminMapper mapper;
    
    public boolean addDoctor(Doctor doctor) {
        // TODO Auto-generated method stub
        /**
         * 处理密码，密码盐
         * 入职日期和离职日期，前端接收date类型，在这里转string类型的YYYY-MM-DD格式后set
         */
        if(mapper.addDoctor(doctor)==1) {
            return true;
        }
        return false;
    }

    public boolean updateDoctor(Doctor doctor) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean deleteDoctor(String id) {
        // TODO Auto-generated method stub
        if(mapper.deleteDoctor(id)==1) {
            return true;
        }
        return false;
    }
    
    
}
