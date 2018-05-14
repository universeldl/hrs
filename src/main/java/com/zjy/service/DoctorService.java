package com.zjy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjy.dao.DoctorMapper;
import com.zjy.dao.VisitMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Registration;
import com.zjy.entity.Visit;
import com.zjy.util.CryptographyHelper;
import com.zjy.vo.DataGridResult;
import com.zjy.vo.DataResult;
import com.zjy.vo.RegistrationResult;

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;
    
    @Autowired
    private VisitMapper visitMapper;

    public boolean updateByPrimaryKeySelective(Doctor doctor) {
        try{
        	if (doctorMapper.updateByPrimaryKeySelective(doctor) == 1) {
        		return true;
        	}
        }catch (Exception e) {
            throw new RuntimeException("更新医生失败");
        }
        return false;
    }

    public int deleteByPrimaryKey(String id) {
        try{
        	return doctorMapper.deleteByPrimaryKey(id);
        }catch (Exception e) {
        	e.printStackTrace();
            throw new RuntimeException("删除医生失败");
        }
    }

    public Doctor selectByDoctorNo(String id) {
        try {
            return doctorMapper.selectByDoctorNo(id);
        }catch(Exception e) {
        	e.printStackTrace();
        	throw new RuntimeException("根据编号查询医生失败");
        }
    }
    
    public List<Doctor> selectDoctorByDepartment(String departmentNo) {
    	return doctorMapper.selectDoctorByDepartment(departmentNo);
    }
    
    public List<Doctor> selectDoctorByDepartmentAndDuty(Map<String, Object> param){
    	return doctorMapper.selectDoctorByDepartmentAndDuty(param);
    }
    
    public List<Doctor> selectDoctorNoDuty() {
    	return doctorMapper.selectDoctorNoDuty();
    }

	public DataResult updatePassword(Doctor doctor, String oldPassword, String newPassword) {
		DataResult dataResult = new DataResult();
		
		if (!doctor.getDoctorPassword().equals(CryptographyHelper.encrypt(oldPassword, doctor.getDoctorSalt()))) {
			dataResult.setStatus(false);
			dataResult.setTips("旧密码错误");
			return dataResult;
		}
		
		doctor.setDoctorSalt(CryptographyHelper.getRandomSalt());
		doctor.setDoctorPassword(CryptographyHelper.encrypt(newPassword, doctor.getDoctorSalt()));
		
        try {
    		if (doctorMapper.updateByPrimaryKeySelective(doctor)==1) {
    			dataResult.setStatus(true);
    			dataResult.setTips("修改密码成功");
    		} else {
    			dataResult.setStatus(false);
    			dataResult.setTips("修改密码失败");
    		}
        }catch(Exception e) {
			dataResult.setStatus(false);
			dataResult.setTips("修改密码失败");
        }
        
		return dataResult;
	}

	public DataGridResult queryListByRegNo(String regNo, int pageNumber,
			int pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<RegistrationResult> departmentList = doctorMapper.queryListByRegNo(regNo);
		PageInfo<RegistrationResult> pageInfo = new PageInfo<RegistrationResult>(departmentList);
		DataGridResult dataGridResult = new DataGridResult(pageInfo.getTotal(), pageInfo.getList(), pageInfo.getPageSize(),
				pageInfo.getPageNum());
		return dataGridResult;
	}

	public boolean confirmVisit(String registrationNo) {
		// TODO Auto-generated method stub
		Registration reg = doctorMapper.queryRegByNo(registrationNo);
		reg.setStatus("2");
		if(visitMapper.insert(reg)==1){
			return true;
		}
		return false;
	}

}