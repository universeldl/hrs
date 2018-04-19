/**
 * 
 */
package com.zjy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.dao.DepartmentMapper;
import com.zjy.entity.Department;
import com.zjy.vo.DataResult;

/**
 * @author Mervyn
 *
 */

@Service
public class DepartmentService {
	@Autowired
	DepartmentMapper departmentMapper;
	
	public DataResult insert(Department department) {
		DataResult dataResult = new DataResult();
		if (departmentMapper.insert(department) == 1) {
			dataResult.setStatus(true);
			dataResult.setTips("添加部门成功");
		} else {
			dataResult.setStatus(false);
			dataResult.setTips("添加部门失败");
		}
		
		return dataResult;
	}
	
	public DataResult deleteByPrimaryKey(String id) {
		DataResult dataResult = new DataResult();
		if (departmentMapper.deleteByPrimaryKey(id) == 1) {
			dataResult.setStatus(true);
			dataResult.setTips("刪除部门成功");
		} else {
			dataResult.setStatus(false);
			dataResult.setTips("刪除部门失败");
		}
		
		return dataResult;
	}
	
	public Department selectByDeptNo(String departmentNo) {
		return departmentMapper.selectByDeptNo(departmentNo);
	}
	
	public List<Department> selectList() {
		return departmentMapper.selectList();
	}
}
