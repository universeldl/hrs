/**
 * 
 */
package com.zjy.service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Medicine> queryByMedicineName(String medicineName) {
        // TODO Auto-generated method stub
        List<Medicine> list = mMapper.selectByMedicineName(medicineName);
        return list;
    }

}
