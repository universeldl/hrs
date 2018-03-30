package com.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.entity.Consultation;
import com.zjy.service.ConsultationService;
import com.zjy.service.VisitService;

/**
 * 就诊相关
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: ConsultationController.java, v 0.1 2018年3月30日 上午10:23:16 zhoujiayi Exp $
 */
@Controller
public class ConsultationController {

    @Autowired
    private ConsultationService service;
    
    @Autowired
    private VisitService visitService;
    
    @RequestMapping("/consultationQuery")
    public String consultationQuery() {
        return "consultationQuery";
    }
    
    /**
     * 输入挂号编号后显示的内容 -- 就诊
     * @param regNo
     * @return
     */
    @RequestMapping("/consultationQueryDetail")
    public String consultationQueryDetail(@RequestParam("regNo") String regNo) {
        Consultation Consultation = service.queryConsultationByNo(regNo);
        
        return "";
    }
    
    /**
     * 医生编写病例  
     * 更新visit表里的病例描述字段
     * @param patientNo
     * @param diagnostic
     * @return
     */
    @RequestMapping("/writeDiagnostic")
    public String writeDiagnostic(@RequestParam("patientNo")String patientNo,
                                  @RequestParam("diagnostic")String diagnostic) {
        if(visitService.updateDiagnostic(patientNo,diagnostic)) {
            return "";
        }
        return "";
    }
}
