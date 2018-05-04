/**
 * 
 */
package com.zjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.PrescriptionMapper;
import com.zjy.entity.Prescription;
import com.zjy.vo.DataResult;

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

    public DataResult insertPrescription(Prescription prescription) {
        // TODO Auto-generated method stub
        DataResult dataResult = new DataResult();
        try {
            if(preMapper.insert(prescription)==1) {
                dataResult.setStatus(true);
                dataResult.setTips("插入成功");
            }
        } catch (Exception e) {
            // TODO: handle exception
            dataResult.setStatus(false);
            dataResult.setTips("插入失败");
        }
        return dataResult;
    }

}
