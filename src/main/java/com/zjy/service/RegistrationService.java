/**
 * 
 */
package com.zjy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.RegistrationMapper;
import com.zjy.entity.Registration;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */

@Service
public class RegistrationService {

	@Autowired
	RegistrationMapper registrationMapper;
	
	public DataResult insert(Registration registration) {
		DataResult dataResult = new DataResult();
		try {
			if (registrationMapper.insert(registration) == 1) {
				dataResult.setStatus(true);
				dataResult.setTips("预约成功");
			} else {
				dataResult.setStatus(false);
				dataResult.setTips("预约失败");
			}
		} catch(Exception e) {
			e.printStackTrace();
			dataResult.setStatus(false);
			dataResult.setTips("预约失败");
		}
		return dataResult;
	}
	
}
