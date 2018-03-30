/**
 * 
 */
package com.zjy.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DoctorMapper;
import com.zjy.dao.DutyMapper;
import com.zjy.entity.Doctor;
import com.zjy.entity.Duty;

/**
 * @author Mervyn
 *
 */

@Service
public class DutyService {

    @Autowired
    private DutyMapper dutymapper;
    
    @Autowired
    private DoctorMapper doctorMapper;
    
    public Duty queryDutyById(String id) {
        // TODO Auto-generated method stub
        try {
            return dutymapper.selectDutyByNo(id);
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("医生编号"+id+"有误，查找值班信息失败");
        }
    }

    /**
     * 1--值班     0--不值班
     * 返回的map是根据部门分，周一到周日每天值班医生的姓名集合
     * 如果要区分上午下午，可以再加一个状态值，
     * 同时将map里面的List<String>变为List<String[]>
     * 
     * @param depNo
     * @return
     */
    public Map<String, List<String>> queryscheduling(String depNo) {
        // TODO Auto-generated method stub
        try {
            List<Doctor> list = doctorMapper.queryDoctorByDepNo(depNo);
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            List<String> Monday = new ArrayList<String>();
            List<String> Tuesday = new ArrayList<String>();
            List<String> Wednesday = new ArrayList<String>();
            List<String> Thursday = new ArrayList<String>();
            List<String> Friday = new ArrayList<String>();
            List<String> Saturday = new ArrayList<String>();
            List<String> Sunday = new ArrayList<String>();
            for(Doctor doctor : list) {
               Duty duty = dutymapper.selectDutyByNo(doctor.getDoctorDepartmentNo());
               if("1".equals(duty.getMonday())) {
                   Monday.add(doctor.getDoctorName());
               }
               if("1".equals(duty.getTuesday())) {
                   Tuesday.add(doctor.getDoctorName());
               }
               if("1".equals(duty.getWednesday())) {
                   Wednesday.add(doctor.getDoctorName());
               }
               if("1".equals(duty.getThursday())) {
                   Thursday.add(doctor.getDoctorName());
               }
               if("1".equals(duty.getFriday())) {
                   Friday.add(doctor.getDoctorName());
               }
               if("1".equals(duty.getSaturday())) {
                   Saturday.add(doctor.getDoctorName());
               }
               if("1".equals(duty.getSunday())) {
                   Sunday.add(doctor.getDoctorName());
               }
            }
            map.put("Monday", Monday);
            map.put("Tuesday", Tuesday);
            map.put("Wednesday", Wednesday);
            map.put("Thursday", Thursday);
            map.put("Friday", Friday);
            map.put("Saturday", Saturday);
            map.put("Sunday", Sunday);
            return map;
        }catch(Exception e) {
            throw new RuntimeException("查看科室值班表失败");
        }
    }

}
