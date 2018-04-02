package com.zjy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.entity.Doctor;
import com.zjy.util.CryptographyHelper;

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
        String password = doctor.getDoctorPassword();
        String salt = CryptographyHelper.getRandomSalt();
        String dPassword = CryptographyHelper.encrypt(password, salt);
        doctor.setDoctorPassword(dPassword);
        doctor.setDoctorSalt(salt);
        try{
            if (doctorMapper.insert(doctor) == 1) {
                return true;
            }
        }catch (Exception e) {
            throw new RuntimeException("插入医生失败");
        }
        return false;
    }
    
    public Map<String, Object> queryDoctorByPage(Map<String, Object> param) {
        // TODO Auto-generated method stub
        Map<String, Object> result = new HashMap<String, Object>();
        List<Doctor> rows = doctorMapper.queryDoctor(param);
        result.put("rows", rows);
        result.put("total", doctorMapper.count(param));
        return result;
    }
}
