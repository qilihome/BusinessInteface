package com.weichat.boss.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.AdminMapper;
import com.weichat.boss.data.pojo.Admin;
import com.weichat.boss.service.admin.AdminService;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin login(Admin admin)
	{
		List<Admin> admins = adminMapper.query(admin);
		if (admins.isEmpty())
		{
			return null;
		}
		return admins.get(0);
	}

	@Override
	public List<Admin> queryByDepart(int deptId) {
		// TODO Auto-generated method stub
		return adminMapper.queryByDepart(deptId);
	}

}
