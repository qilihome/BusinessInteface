package com.weichat.boss.data.dao;

import java.util.List;

import com.weichat.boss.data.pojo.Admin;

public interface AdminMapper
{
	List<Admin> query(Admin admin);
	
	List<Admin> queryByDepart(int deptId);
}