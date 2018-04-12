/**
 * 
 */
package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.PatientMapper;
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
		return patientMapper.insert(patient);
	}
	
	public int updateByPrimaryKeySelective(Patient patient) {
		return patientMapper.updateByPrimaryKeySelective(patient);
	}
	
}
