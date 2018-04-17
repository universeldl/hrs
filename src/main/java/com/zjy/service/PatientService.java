/**
 * 
 */
package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.PatientMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Patient;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */

@Service
public class PatientService {

	@Autowired
	PatientMapper patientMapper;
	
	public DataResult insert(Patient patient) {
		DataResult dataResult = new DataResult();
        try {
    		if (patientMapper.insert(patient)==1) {
    			dataResult.setStatus(true);
    			dataResult.setTips("添加病人成功");
    		}
        }catch(Exception e) {
			dataResult.setStatus(false);
			dataResult.setTips("添加病人失败");
        }
		return dataResult;
	}
	
	public DataResult updateByPrimaryKeySelective(Patient patient) {
		DataResult dataResult = new DataResult();
        try {
    		if (patientMapper.updateByPrimaryKeySelective(patient)==1) {
    			dataResult.setStatus(true);
    			dataResult.setTips("更新病人成功");
    		}
        }catch(Exception e) {
			dataResult.setStatus(false);
			dataResult.setTips("更新病人失败");
        }
		return dataResult;
	}
	
    public Patient selectByPatientNo(String id) {
        try {
            return patientMapper.selectByPatientNo(id);
        }catch(Exception e) {
            throw new RuntimeException("根据编号查询病人失败");
        }
    }
}
