/**
 * 
 */
package com.zjy.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjy.entity.Department;
import com.zjy.entity.Doctor;
import com.zjy.service.AdminService;
import com.zjy.service.DepartmentService;
import com.zjy.service.PatientService;
import com.zjy.util.Constants;
import com.zjy.util.CryptographyHelper;
import com.zjy.vo.BatchResult;
import com.zjy.vo.DataGridResult;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminManagementController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	PatientService patientService;
	
    /**
     * 新增医生
     * @param doctor
     * @return
     */
    @RequestMapping(value="/addDoctor", method = RequestMethod.POST)
    public DataResult insertDoctor(@RequestBody Doctor doctor) {
    	DataResult dataResult;
    	doctor.setId();
    	doctor.setDoctorNo();
    	doctor.setDoctorSalt(CryptographyHelper.getRandomSalt());
    	doctor.setDoctorPassword(CryptographyHelper.encrypt(doctor.getDoctorPassword(), doctor.getDoctorSalt()));
    	doctor.setCreateTime();
    	doctor.setUpdateTime();
        dataResult = adminService.insert(doctor);
        
        return dataResult;
    }
    
    /**
     * 医生列表    条件查询
     * 条件：姓名，科室，状态（在职-1/离职-0），入职时间
     * @return
     */
    @RequestMapping(value="/queryDoctorList", method=RequestMethod.POST)
    @ResponseBody
    public DataGridResult queryDoctorList(@RequestParam(value = "pageSize", required = true) int pageSize,
                                  @RequestParam(value = "pageNumber", required = true) int pageNumber,
                                  @RequestParam(value="name", required=false)String name,
                                  @RequestParam("depNo")String depNo,
                                  @RequestParam("status")String status,
                                  @RequestParam("startTime")String startTime,
                                  @RequestParam("endTime")String endTime) {
       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("name", null==name?"":name);
        param.put("depNo", null==depNo?"":depNo);
        param.put("status", null==status?"":status);
        try {
            param.put("startTime", null==startTime||"".equals(startTime)?"":sdf.parse(startTime));
            param.put("endTime", null==endTime||"".equals(endTime)?"":sdf.parse(endTime));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DataGridResult dataGridResult = adminService.queryDoctorByPage(param, pageNumber, pageSize);
        return dataGridResult;
    }
    
    /**
     * 删除医生--医生离职
     * @param doctorNos
     * @return
     */
    @RequestMapping(value = "/deleteDoctor", method = RequestMethod.POST)
    @ResponseBody
    public BatchResult<Doctor> deleteDoctor(@RequestParam("doctorNos") String doctorNos) {
        BatchResult<Doctor> batchResult;
        
        String[] doctorNoArray = doctorNos.split(",");
        
        batchResult = adminService.deleteByDoctorNo(doctorNoArray);
        
        return batchResult;
    }
    
    
    
    @RequestMapping(value = "/showQueryPatient")
    public String showQueryPatient() {
    	return "admin/queryPatient";
    }
    
    /**
     * 添加部门
     * @author Mervyn
     * 
     * @param name
     * @return
     */
    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    @ResponseBody
    public DataResult addDepartment(@RequestParam("name") String name) {
    	DataResult dataResult;
    	
    	Department department = new Department();
    	department.setId();
		do {
	    	department.setDepartmentNo();
		} while (departmentService.selectByDeptNo(department.getDepartmentNo()) != null);
    	department.setDepartmentNo();
    	department.setDepartmentName(name);
    	department.setIsDeleted(Constants.NOT_DELETED);
    	department.setCreateTime();
    	department.setUpdateTime();
    	
    	dataResult = departmentService.insert(department);
    	
        return dataResult;
    }
    
    /**
     * 删除部门
     * @param departmentNos
     * @return
     */
    @RequestMapping(value = "/deleteDepartment", method = RequestMethod.POST)
    @ResponseBody
    public BatchResult<Department> deleteDepartment(@RequestParam("departmentNos") String departmentNos) {
    	BatchResult<Department> batchResult;
    	
    	String[] departmentNoArray = departmentNos.split(",");
    	
    	batchResult = departmentService.deleteByDeptNo(departmentNoArray);
    	
        return batchResult;
    }
    

    /**
     * 根据编号查科室
     * @param departmentNo
     * @return
     */
    @RequestMapping(value="/selectByDepNo", method = RequestMethod.POST)
    @ResponseBody
    public Department selectByDepNo(@RequestParam("departmentNo") String departmentNo) {
        Department department = departmentService.selectByDeptNo(departmentNo);
        return department;
    }
    
    
    /**
     * 修改科室
     * @param departmentNo
     * @param depName
     * @return
     */
    @RequestMapping(value="/updateDepartment", method = RequestMethod.POST)
    public DataResult updateDepartment(@RequestParam("departmentNo") String departmentNo,
                                 @RequestParam("depName") String depName) {
        DataResult dataResult = new DataResult();
        if(depName==null||"".equals(depName)) {
            dataResult.setStatus(false);
            dataResult.setTips("修改失败,科室名称不能为空！");
        }
        dataResult = departmentService.updateByNo(departmentNo, depName);
        return dataResult;
    }
    
    
    /**
     * 根据科室名查询部门信息并分页
     * @author Mervyn
     * 
     * @param pageSize
     * @param pageNumber
     * @param departmentName
     * @return
     */
    @RequestMapping(value = "/queryDepartmentList", method = RequestMethod.POST)
    @ResponseBody
    public DataGridResult queryDepartmentList(@RequestParam(value = "pageSize", required = true) int pageSize,
    		@RequestParam(value = "pageNumber", required = true) int pageNumber,
    		@RequestParam(value = "departmentName") String departmentName) {
    	Department department = new Department();
    	if (departmentName != null && !"".equals(departmentName))
    		department.setDepartmentName(departmentName);
    	DataGridResult dataGridResult = departmentService.queryListByName(department, pageNumber, pageSize);
    	return dataGridResult;
    }
    
    @RequestMapping(value = "/queryPatientList", method = RequestMethod.POST)
    @ResponseBody
    public DataGridResult queryPatientList(@RequestParam(value = "pageSize", required = true) int pageSize,
    		@RequestParam(value = "pageNumber", required = true) int pageNumber,
    		@RequestParam(value = "patientName") String patientName,
    		@RequestParam(value = "patientSex") String patientSex,
    		@RequestParam(value = "patientMinAge") String patientMinAge,
    		@RequestParam(value = "patientMaxAge") String patientMaxAge,
    		@RequestParam(value = "patientPhone") String patientPhone) {
    	Map<String, String> map = new HashMap<String, String>();
    	if (patientName != null && !"".equals(patientName))
    		map.put("patientName", patientName);
    	if (patientSex != null && !"null".equals(patientSex))
    		map.put("patientSex", patientSex);
    	if (patientMinAge != null && !"".equals(patientMinAge))
    		map.put("patientMinAge", patientMinAge);
    	if (patientMaxAge != null && !"".equals(patientMaxAge))
    		map.put("patientMaxAge", patientMaxAge);
    	if (patientPhone != null && !"".equals(patientPhone))
    		map.put("patientPhone", patientPhone);
    	DataGridResult dataGridResult = patientService.pageQueryPatientByWhere(map, pageNumber, pageSize);
    	return dataGridResult;
    }
}
