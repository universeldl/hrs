package com.zjy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Patient;
import com.zjy.service.PatientService;
import com.zjy.util.Constants;
import com.zjy.util.CryptographyHelper;
import com.zjy.vo.DataResult;

/**
 * 
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: PatientController.java, v 0.1 2018年3月30日 上午10:23:22 zhoujiayi Exp $
 */
@RequestMapping("/patient")
@Controller
public class PatientController {

	@Autowired
	PatientService patientService;
	
	@RequestMapping(value="/toRegistration", method=RequestMethod.GET)
	public String toRegistrate() {
		return "registration";
	}

	@RequestMapping(value="/registration", method=RequestMethod.POST)
	@ResponseBody
	public DataResult registrate(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "birth", required = true) String birth,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "gender", required = true) String gender) {
		
		DataResult dataResult = new DataResult();
		
		Patient patient = new Patient();
		patient.setId();
		patient.setPatientNo();
		patient.setPatientName(name);
		patient.setPatientSalt(CryptographyHelper.getRandomSalt());
		patient.setPatientPassword(CryptographyHelper.encrypt(password, patient.getPatientSalt()));
		patient.setPatientSex(gender);
		try {
			patient.setPatientBirth(new SimpleDateFormat("yyyy-MM-dd").parse(birth));
		} catch (ParseException e) {
			throw new RuntimeException("日期格式化错误");
		}
		patient.setPatientPhone(phone);
		patient.setIsDeleted(Constants.NOT_DELETED);
		patient.setCreateTime();
		patient.setUpdateTime();
		
		dataResult.setStatus(patientService.insert(patient)==1?true:false);
		dataResult.setTips(patient.getPatientNo());
		
		return dataResult;
		
	}
}
