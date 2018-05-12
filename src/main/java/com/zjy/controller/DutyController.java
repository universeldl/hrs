package com.zjy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Duty;
import com.zjy.service.DutyService;
import com.zjy.vo.DataGridResult;

/**
 * 医生排班功能
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: SchedulingController.java, v 0.1 2018年3月21日 上午10:54:01 zhoujiayi Exp $
 */
@RequestMapping("/duty")
@Controller
public class DutyController {
    
    @Autowired
    private DutyService dutyService;
    
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
    public String viewScheduling(@RequestParam("id")String id, ModelMap model) {
        Duty duty = dutyService.queryDutyById(id);
        model.put("duty", duty);
        return "";
    }
    
    /**
     * 各科室排班表（像课程表那样）
     * 必须选择科室
     * @return
     */
    @RequestMapping("/schedulingList")
    public String schedulingList(@RequestParam("depNo")String depNo) {
        Map<String,List<String>> map = dutyService.queryscheduling(depNo);
        
        return "";
    }
    
    
	@RequestMapping(value = "/queryDutyList", method = RequestMethod.POST)
	@ResponseBody
	public DataGridResult queryDutyList(@RequestParam(value = "pageSize", required = true) int pageSize,
    		@RequestParam(value = "pageNumber", required = true) int pageNumber,
    		@RequestParam(value="doctorName") String doctorName) throws ParseException {
		
		Map<String, String> map = new HashMap<String, String>();
		if (doctorName != null && !"".equals(doctorName))
			map.put("doctorName", doctorName);
		DataGridResult dataGridResult = dutyService.selectDutyByPage(map, pageNumber, pageSize);
		
		return dataGridResult;
	}
}
