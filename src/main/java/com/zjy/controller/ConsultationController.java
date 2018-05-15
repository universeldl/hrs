package com.zjy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zjy.entity.Consultation;
import com.zjy.entity.Prescription;
import com.zjy.service.ConsultationService;
import com.zjy.service.MedicineService;
import com.zjy.service.PrescriptionService;
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
    
    @Autowired
    private MedicineService medicineService;
    
    @Autowired
    private PrescriptionService preService;
    
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
    public String consultationQueryDetail(@RequestParam("regNo") String regNo, HttpServletRequest request) {
        Consultation consultation = service.queryConsultationByNo(regNo);
        request.getSession().setAttribute("consultation", consultation);
        return "doctor/visitDetail";
    }
    
    /**
     * 医生编写病例  
     * 更新visit表里的病例描述字段
     * @param patientNo
     * @param diagnostic
     * @return
     */
    @RequestMapping("/writeDiagnostic")
    public String writeDiagnostic(@RequestParam("registrationNo")String registrationNo,
                                  @RequestParam("diagnostic")String diagnostic) {
        if(visitService.updateDiagnostic(registrationNo,diagnostic)) {
            return "";
        }
        return "";
    }
    
    /**
     * 药品搜索
     * 根据药品名称模糊匹配
     * @return
     */
    @RequestMapping("/medicineQuery")
    public Map<String, Object> medicineQuery(@RequestParam("medicineName")String medicineName,
                                             int pageSize,int pageNumber) {
        int a = (pageNumber-1)*pageSize;
        int b = pageSize;
        Map<String, Object> map = medicineService.queryByMedicineName(medicineName,a,b);
        return map;
    }
    
    /**
     * 处方确认，传多个对象回来
     * 存入数据库
     * @param list
     * @return
     */
    @RequestMapping("/confirmMedicine")
    public String confirmMedicine(@RequestBody List<Prescription> list) {
        if(preService.addPrescriptions(list)) {
            return "";
        }
        return "";
    }
}
