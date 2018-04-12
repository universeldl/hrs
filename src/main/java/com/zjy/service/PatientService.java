/**
 * 
 */
package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.PatientMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Patient;

/**
 * @author Mervyn
 *
 */

@Service
public class PatientService {

	@Autowired
	PatientMapper patientMapper;
	
	public int insert(Patient patient) {
        try {
    		return patientMapper.insert(patient);
        }catch(Exception e) {
            throw new RuntimeException("插入病人失败");
        }
	}
	
	public int updateByPrimaryKeySelective(Patient patient) {
        try {
    		return patientMapper.updateByPrimaryKeySelective(patient);
        }catch(Exception e) {
            throw new RuntimeException("更新病人失败");
        }
	}
	
    public Patient selectByPatientNo(String id) {
        try {
            return patientMapper.selectByPatientNo(id);
        }catch(Exception e) {
            throw new RuntimeException("根据编号查询病人失败");
        }
    }
}
