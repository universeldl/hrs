/**
 * 
 */
package com.zjy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Doctor;
import com.zjy.entity.Prescription;
import com.zjy.service.DoctorService;
import com.zjy.service.MedicineService;
import com.zjy.service.PrescriptionService;
import com.zjy.vo.DataGridResult;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@Autowired
    MedicineService medicineService;
	
	@Autowired
	PrescriptionService preService;
	
	@RequestMapping("/loadDoctor")
	@ResponseBody
	public List<Doctor> loadDoctor(@RequestParam(value="departmentNo") String departmentNo) {
		return doctorService.selectDoctorByDepartment(departmentNo);
	}
	
	/**
	 * 开药时药品查询列表
	 * @param pageSize
	 * @param pageNumber
	 * @param medicineName
	 * @return
	 */
	@RequestMapping("/queryMedicine")
	@ResponseBody
	public DataGridResult queryMedicine(@RequestParam(value = "pageSize", required = true) int pageSize,
	                                    @RequestParam(value = "pageNumber", required = true) int pageNumber,
	                                    @RequestParam("medicineName") String medicineName) {
	    
	    DataGridResult dataGridResult = medicineService.queryListByName(medicineName, pageNumber, pageSize);
        return dataGridResult;
	}
	
	
	/**
	 * 开药时的记录，添加到处方表
	 * @param prescription
	 * @return
	 */
	@RequestMapping(value="/addMedicine", method=RequestMethod.POST)
	@ResponseBody
	public DataResult addMedicine(Prescription prescription) {
	    DataResult dataResult;
	    prescription.setId();
	    dataResult = preService.insertPrescription(prescription);
	    return dataResult;
	}
	
}
