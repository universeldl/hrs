package com.zjy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.entity.Duty;
import com.zjy.service.DutyService;

/**
 * 医生排班功能
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: SchedulingController.java, v 0.1 2018年3月21日 上午10:54:01 zhoujiayi Exp $
 */
@Controller
public class DutyController {
    
    @Autowired
    private DutyService service;
    
    /**
     * 排班调整
     * 只能输入医生编号，先查看单个医生的值班情况，
     * 每一次只能对一个医生进行修改
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/changeScheduling")
    public String viewScheduling(@RequestParam("id")String id, Model model) {
        Duty duty = service.queryDutyById(id);
        
        return "";
    }
    
    /**
     * 各科室排班表（像课程表那样）
     * 必须选择科室
     * @return
     */
    @RequestMapping("/schedulingList")
    public String schedulingList(@RequestParam("depNo")String depNo) {
        Map<String,List<String>> map = service.queryscheduling(depNo);
        
        return "";
    }
}
