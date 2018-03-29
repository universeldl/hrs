package com.zjy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.entity.Doctor;

/**
 * 
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: AdminService.java, v 0.1 2018年3月29日 下午3:26:00 zhoujiayi Exp $
 */
@Service
public class AdminService {
    
    @Autowired
    private DoctorMapper doctorMapper;

    public boolean insert(Doctor doctor) {
        /**
         * 处理密码，密码盐
         * 入职日期和离职日期，前端接收date类型，在这里转string类型的YYYY-MM-DD格式后set
         */
        try{
            if (doctorMapper.insert(doctor) == 1) {
                return true;
            }
        }catch (Exception e) {
            throw new RuntimeException("插入医生失败");
        }
        return false;
    }
    
    public List<Doctor> queryDoctorByPage(Map<String, Object> param) {
        // TODO Auto-generated method stub
        List<Doctor> list = doctorMapper.queryDoctor(param);
        return list;
    }
}
