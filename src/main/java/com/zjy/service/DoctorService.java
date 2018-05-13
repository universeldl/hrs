package com.zjy.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Patient;
import com.zjy.util.CryptographyHelper;
import com.zjy.vo.DataResult;

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

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

}