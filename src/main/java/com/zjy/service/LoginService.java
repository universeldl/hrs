package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.dao.PatientMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Patient;

@Service
public class LoginService {
    
    @Autowired
    private DoctorMapper dMapper;
    
    @Autowired
    private PatientMapper pMapper;

    public boolean DLogin(String id, String password) {
        // TODO Auto-generated method stub
//        Doctor doctor = dMapper.selectByPrimaryKey(id);
//        if(null!=doctor&&doctor.getPassword().equals(password)) {
//            return true;
//        }
        return false;
    }

    public boolean PLogin(String id, String password) {
        // TODO Auto-generated method stub
//        Patient patient = pMapper.queryPatient(id);
//        if(null!=patient&&patient.getPassword().equals(password)) {
//            return true;
//        }
        return false;
    }

}
