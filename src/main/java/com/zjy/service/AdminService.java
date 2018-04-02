package com.zjy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.entity.Doctor;
import com.zjy.vo.DataResult;

/**
 * 
 * TODO
 *
 * @author zhoujiayi
 * @version $Id: AdminService.java, v 0.1 2018年3月29日 下午3:26:00 zhoujiayi Exp $
 */
@Service
public class AdminService {
    
    @Autowired
    private DoctorMapper doctorMapper;

    public DataResult insert(Doctor doctor) {
    	DataResult dataResult = new DataResult();
        try{
            if (doctorMapper.insert(doctor) == 1) {
                dataResult.setStatus(true);
                dataResult.setTips("插入成功");
            }
        }catch (Exception e) {
            dataResult.setStatus(false);
            dataResult.setTips("插入失败");
        }
        return dataResult;
    }
    
    public Map<String, Object> queryDoctorByPage(Map<String, Object> param) {
        // TODO Auto-generated method stub
        Map<String, Object> result = new HashMap<String, Object>();
        List<Doctor> rows = doctorMapper.queryDoctor(param);
        result.put("rows", rows);
        result.put("total", doctorMapper.count(param));
        return result;
    }
}
