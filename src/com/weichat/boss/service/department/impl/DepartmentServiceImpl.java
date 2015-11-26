package com.weichat.boss.service.department.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.DepartmentMapper;
import com.weichat.boss.data.pojo.Department;
import com.weichat.boss.service.department.DepartmentService;


@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Override
	public List<Department> list() {
		return departmentMapper.list();
	}
}
