package com.zjy.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.dao.PatientMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Patient;
import com.zjy.util.Constants;
import com.zjy.util.CryptographyHelper;
import com.zjy.vo.DataResult;

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
    
    public DataResult DLogin(String id, String password, String verifyCode, String remindMe, HttpServletRequest request) {
    	
    	DataResult dataResult = new DataResult();
    	
        Doctor doctor = dMapper.selectByDoctorNo(id);
        if (verifyCode.equalsIgnoreCase((String) request.getSession().getAttribute(Constants.VERIFY_CODE))) {
        	if (doctor != null) {
        		if (doctor.getDoctorPassword().equals(CryptographyHelper.encrypt(password, doctor.getDoctorSalt()))) {
        			request.getSession().setAttribute(Constants.SESSION_USER, doctor);
        			/*
        			 * 记住账号功能待完成        			
        			 * */
        			dataResult.setStatus(true);
        			dataResult.setTips("登录成功");
        		} else {
        			dataResult.setStatus(false);
        			dataResult.setTips("密码错误");
        		}
        	}
        	else {
        		dataResult.setStatus(false);
        		dataResult.setTips("账号不存在");
        	}
        } else {
        	dataResult.setStatus(false);
        	dataResult.setTips("验证码错误");
        }
        return dataResult;
    }

    public DataResult PLogin(String id, String password, String verifyCode, String remindMe, HttpServletRequest request) {
    	
    	DataResult dataResult = new DataResult();
    	
        Patient patient = pMapper.selectByPatientNo(id);
        
        if (verifyCode.equalsIgnoreCase((String) request.getSession().getAttribute(Constants.VERIFY_CODE))) {
        	if (patient != null) {
        		if (patient.getPatientPassword().equals(CryptographyHelper.encrypt(password, patient.getPatientSalt()))) {
        			request.getSession().setAttribute(Constants.SESSION_USER, patient);
        			/*
        			 * 记住账号功能待完成        			
        			 * */
        			dataResult.setStatus(true);
        			dataResult.setTips("登录成功");
        		} else {
        			dataResult.setStatus(false);
        			dataResult.setTips("密码错误");
        		}
        	}
        	else {
        		dataResult.setStatus(false);
        		dataResult.setTips("账号不存在");
        	}
        } else {
        	dataResult.setStatus(false);
        	dataResult.setTips("验证码错误");
        }
        
        return dataResult;
    }
}
