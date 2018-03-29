package com.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 排班编辑
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/viewScheduling")
    public String viewScheduling(@RequestParam("id")String id, Model model) {
        
        return "";
    }
    
    /**
     * 各科室排班表（像课程表那样）
     * 
     * @return
     */
    @RequestMapping("/schedulingList")
    public String schedulingList() {
        
        return "";
    }
}
