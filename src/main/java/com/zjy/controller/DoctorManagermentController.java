package com.zjy.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Doctor;
import com.zjy.service.DoctorService;

/**
 * 菜单 ： 医生管理 TODO
 *
 * @author zhoujiayi
 * @version $Id: DoctorManagermentController.java, v 0.1 2018年3月21日 上午9:54:55 zhoujiayi Exp $
 */
@Controller
public class DoctorManagermentController {

    @Autowired
    private DoctorService service;

    /**
     * 医生查询，条件查询，不是查所有字段
     * 医生编号，状态，开始时间，截止时间
     * 状态是指在职还是离职，在职是0，离职是1==>对应isDeleted，默认在职
     * 在职的开始时间和截止时间是筛选入职时间
     * 离职的开始时间和截止时间是筛选离职时间
     * @param model 存放查询结果
     * @param id
     * @param status
     * @param startTime
     * @param endTime
     * @return
     */
    @RequestMapping("/viewDoctor")
    @ResponseBody
    public String viewDoctor(Model model, @RequestParam("id") String id,
            @RequestParam("status") String status, 
            @RequestParam("startTime") Date startTime,
            @RequestParam("endTime") Date endTime) {
        
        return "";
    }

    /**
     * 新增医生
     * 
     * @param doctor
     * @return
     */
    @RequestMapping("/addDoctor")
    public String addDoctor(Doctor doctor) {
        service.insert(doctor);
        return "";
    }
    
    /**
     * 修改医生信息
     * 在医生查询结果的倒数第二列是修改按钮
     * 点击修改弹出模态框，先调详情，点保存后再调这个方法
     * 修改信息保存后要改updateTime
     * 
     * @param doctor
     * @return
     */
    @RequestMapping("/updateDoctor")
    public String updateDoctor(Doctor doctor) {
        if(service.updateByPrimaryKeySelective(doctor)) {
            return "";
        }
        return "";
    }
    
    /**
     * 详情
     * 在医生查询结果的最后一列是详情按钮
     * 点击后弹出模态框，底部有删除按钮
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/doctorDetail")
    public String doctorDetail(@RequestParam("id") String id,Model model) {
        
        return "";
    }
}
