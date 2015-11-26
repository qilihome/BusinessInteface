package com.weichat.boss.service.admin;

import java.util.List;

import com.weichat.boss.data.pojo.Admin;

/**
 * 账户
 * @author liqi
 * phone 18771970972
 * qq 197399622
 */
public interface AdminService
{
	Admin login(Admin admin);
	
	List<Admin> queryByDepart(int deptId);
}
