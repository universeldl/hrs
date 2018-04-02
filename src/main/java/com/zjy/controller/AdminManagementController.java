/**
 * 
 */
package com.zjy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Doctor;
import com.zjy.service.AdminService;
import com.zjy.util.Constants;
import com.zjy.util.CryptographyHelper;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */

@RequestMapping("/admin")
public class AdminManagementController {

	@Autowired
	AdminService adminService;
	
    /**
     * 新增医生
     * @param doctor
     * @return
     */
    @RequestMapping("/insertDoctor")
    public DataResult insertDoctor(@RequestBody Doctor doctor) {
    	DataResult dataResult;
        dataResult = adminService.insert(doctor);
        return dataResult;
    }
    
    /**
     * 医生列表    条件查询
     * 条件：姓名，科室，状态（在职-1/离职-0），入职时间
     * @return
     */
    @RequestMapping("/queryDoctorList")
    public Map<String, Object> queryDoctorList(@RequestParam("name")String name,
                                  @RequestParam("depNo")String depNo,
                                  @RequestParam("status")String status,
                                  @RequestParam("startTime")Date startTime,
                                  @RequestParam("endTime")Date endTime,
                                  int pageSize,int pageNumber) {
        int a = (pageNumber-1)*pageSize;
        int b = pageSize;
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name", null==name?"":name);
        param.put("depNo", null==depNo?"":depNo);
        param.put("status", null==status?"":status);
        param.put("startTime", null==startTime?"":startTime);
        param.put("endTime", null==endTime?"":endTime);
        param.put("a", a);
        param.put("b", b);
        Map<String, Object> map = adminService.queryDoctorByPage(param);
        return map;
    }
    
}
