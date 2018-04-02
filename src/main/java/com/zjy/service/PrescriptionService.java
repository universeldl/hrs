/**
 * 
 */
package com.zjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.PrescriptionMapper;
import com.zjy.entity.Prescription;

/**
 * @author Mervyn
 *
 */

@Service
public class PrescriptionService {
    
    @Autowired
    private PrescriptionMapper preMapper;

    public boolean addPrescriptions(List<Prescription> list) {
        // TODO Auto-generated method stub
        try {
            preMapper.addPrescriptions(list);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            throw new RuntimeException("处方批量插入失败");
        }
    }

}
