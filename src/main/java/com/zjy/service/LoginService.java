package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.dao.PatientMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Patient;

/**
 * 
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: LoginService.java, v 0.1 2018年3月29日 上午10:41:23 zhoujiayi Exp $
 */
@Service
public class LoginService {
    
    @Autowired
    private DoctorMapper dMapper;
    
    @Autowired
    private PatientMapper pMapper;

    public boolean DLogin(String id, String password) {
        // TODO Auto-generated method stub
        Doctor doctor = dMapper.selectByDoctorNo(id);
        if(null!=doctor&&doctor.getDoctorPassword().equals(password)) {
            return true;
        }
        return false;
    }

    public boolean PLogin(String id, String password) {
        // TODO Auto-generated method stub
        Patient patient = pMapper.selectByPatientNo(id);
        if(null!=patient&&patient.getPatientPassword().equals(password)) {
            return true;
        }
        return false;
    }

}
