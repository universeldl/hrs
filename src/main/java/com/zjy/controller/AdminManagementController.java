package com.zjy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.entity.Doctor;
import com.zjy.service.AdminService;

/**
 * 管理员功能
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: AdminManagementController.java, v 0.1 2018年3月29日 下午3:00:27 zhoujiayi Exp $
 */
@Controller
public class AdminManagementController {
    
    @Autowired
    private AdminService aService;
    
    /**
     * 新增医生
     * @param doctor
     * @return
     */
    @RequestMapping("/insertDoctor")
    public String insertDoctor(@RequestBody Doctor doctor) {
        if(aService.insert(doctor)) {
            return "";
        }
        return "";
    }
    
    /**
     * 医生列表    条件查询
     * 条件：姓名，科室，状态（在职-1/离职-0），入职时间
     * @return
     */
    @RequestMapping("/queryDoctorList")
    public String queryDoctorList(@RequestParam("name")String name,
                                  @RequestParam("depNo")String depNo,
                                  @RequestParam("status")String status,
                                  @RequestParam("startTime")Date startTime,
                                  @RequestParam("endTime")Date endTime) {
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name", null==name?"":name);
        param.put("depNo", null==depNo?"":depNo);
        param.put("status", null==status?"":status);
        param.put("startTime", null==startTime?"":startTime);
        param.put("endTime", null==endTime?"":endTime);
        List<Doctor> list = aService.queryDoctorByPage(param);
        
        return "";
    }
    
}
