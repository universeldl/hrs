/**
 * 
 */
package com.zjy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Doctor;
import com.zjy.entity.Duty;
import com.zjy.service.DoctorService;
import com.zjy.service.DutyService;
import com.zjy.util.Constants;

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
	DutyService dutyService;
	
	/**
	 * 根据部门和值班时间获取医生
	 * @author Mervyn
	 * 
	 * @param departmentNo
	 * @param viewDate
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/loadDoctor")
	@ResponseBody
	public List<Doctor> loadDoctor(@RequestParam(value="departmentNo") String departmentNo,
			@RequestParam(value="viewDate") String viewDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(viewDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		Duty duty = new Duty();
		switch (dayOfWeek) {
		case 1:
			duty.setSunday(Constants.ON_DUTY);
			break;
		case 2:
			duty.setMonday(Constants.ON_DUTY);
			break;
		case 3:
			duty.setTuesday(Constants.ON_DUTY);
			break;
		case 4:
			duty.setWednesday(Constants.ON_DUTY);
			break;
		case 5:
			duty.setThursday(Constants.ON_DUTY);
			break;
		case 6:
			duty.setFriday(Constants.ON_DUTY);
			break;
		case 7:
			duty.setSaturday(Constants.ON_DUTY);
			break;
		}
		List<String> doctorNos = dutyService.selectDoctorByDuty(duty);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("departmentNo", departmentNo);
		if (doctorNos.size() == 0)
			return new ArrayList<Doctor>();
		param.put("doctorNos", doctorNos);
		return doctorService.selectDoctorByDepartmentAndDuty(param);
	}
	
}
