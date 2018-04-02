/**
 * 
 */
package com.zjy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.MedicineMapper;
import com.zjy.entity.Medicine;

/**
 * @author Mervyn
 *
 */

@Service
public class MedicineService {
    
    @Autowired
    private MedicineMapper mMapper;

    public Map<String, Object> queryByMedicineName(String medicineName, int a, int b) {
        // TODO Auto-generated method stub
        Map<String, Object> result = new HashMap<String, Object>();
        List<Medicine> rows = mMapper.selectByMedicineName(medicineName,a,b);
        result.put("rows", rows);
        result.put("total", mMapper.count(medicineName));
        return result;
    }

}
