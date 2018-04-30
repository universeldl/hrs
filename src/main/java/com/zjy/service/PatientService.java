/**
 * 
 */
package com.zjy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.dao.PatientMapper;
import com.zjy.entity.Department;
import com.zjy.entity.Patient;
import com.zjy.vo.DataGridResult;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */

@Service
public class PatientService {

	@Autowired
	PatientMapper patientMapper;
	
	public DataResult insert(Patient patient) {
		DataResult dataResult = new DataResult();
        try {
    		if (patientMapper.insert(patient)==1) {
    			dataResult.setStatus(true);
    			dataResult.setTips("添加病人成功");
    		}
        }catch(Exception e) {
			dataResult.setStatus(false);
			dataResult.setTips("添加病人失败");
        }
		return dataResult;
	}
	
	public DataResult updateByPrimaryKeySelective(Patient patient) {
		DataResult dataResult = new DataResult();
        try {
    		if (patientMapper.updateByPrimaryKeySelective(patient)==1) {
    			dataResult.setStatus(true);
    			dataResult.setTips("更新病人成功");
    		}
        }catch(Exception e) {
			dataResult.setStatus(false);
			dataResult.setTips("更新病人失败");
        }
		return dataResult;
	}
	
    public Patient selectByPatientNo(String id) {
        try {
            return patientMapper.selectByPatientNo(id);
        }catch(Exception e) {
            throw new RuntimeException("根据编号查询病人失败");
        }
    }
    
	public DataGridResult pageQueryPatientByWhere(Map<String, String> map, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Patient> patientList = patientMapper.pageQueryPatientByWhere(map);
		for (Patient p : patientList) {
			System.out.println(p.getPatientName());
		}
		if(patientList == null) {
			System.out.println("null!!!!");
		}
		PageInfo<Patient> pageInfo = new PageInfo<Patient>(patientList);
		DataGridResult dataGridResult = new DataGridResult(pageInfo.getTotal(), pageInfo.getList(), pageInfo.getPageSize(),
				pageInfo.getPageNum());
		return dataGridResult;
	}
}
