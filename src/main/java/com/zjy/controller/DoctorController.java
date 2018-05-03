/**
 * 
 */
package com.zjy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Doctor;
import com.zjy.service.DoctorService;

/**
 * @author Mervyn
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@RequestMapping("/loadDoctor")
	@ResponseBody
	public List<Doctor> loadDoctor(@RequestParam(value="departmentNo") String departmentNo) {
		return doctorService.selectDoctorByDepartment(departmentNo);
	}
	
}
