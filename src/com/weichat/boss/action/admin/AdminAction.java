package com.weichat.boss.action.admin;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.weichat.boss.core.base.BaseAction;
import com.weichat.boss.core.util.MD5andKL;
import com.weichat.boss.data.pojo.Admin;
import com.weichat.boss.service.admin.AdminService;

public class AdminAction extends BaseAction
{
	private static final long serialVersionUID = -3847959479692731804L;
	private static final Logger logger = Logger.getLogger(AdminAction.class);
	
	@Autowired
	private AdminService adminService;
	
	
	private String userName;
	
	private String password;
	
	private int deptId;
	
	public String login() throws IOException{
		Admin admin = new Admin();
		admin.setCount(userName);
		admin.setPassword(MD5andKL.md5222(password));
		admin = adminService.login(admin);
		String result = JSONObject.fromObject(admin).toString();
		System.out.print("result============"+result);
		this.getResponse().getWriter().write(result);
		return null;
	}
	
	
	public String queryByDepart() throws IOException{
		List<Admin> list = adminService.queryByDepart(deptId);
		String result = JSONArray.fromObject(list).toString();
		System.out.print("result============"+result);
		response.setContentType("text/xml;charset=utf-8");
		this.getResponse().getWriter().write(result);
		return null;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	
	
}
