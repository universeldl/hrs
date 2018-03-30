/**
 * 
 */
package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.VisitMapper;

/**
 * @author Mervyn
 *
 */

@Service
public class VisitService {
    
    @Autowired
    private VisitMapper vMapper;

    public boolean updateDiagnostic(String patientNo, String diagnostic) {
        // TODO Auto-generated method stub
        if(vMapper.updateDiagnostic(patientNo,diagnostic)==1) {
            return true;
        }
        return false;
    }

}
