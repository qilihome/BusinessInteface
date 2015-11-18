package com.weichat.boss.data.entity;

import java.util.Date;

/**
 * 操作员明细表tb_sys_ADMIN
 * 
 * @author liqi
 * phone 18771970972
 * qq 197399622
 *
 */
public class Admin
{
	/* id */
	private int id;
	/* 登录账号 */
	private String count;
	/* 操作员名 */
	private String name;
	/* 部门ID */
	private int deptId;
	/* 密码 */
	private String password;
	/* 登陆IP */
	private String loginIP;
	/* 登陆时间 */
	private Date loginTime;
	/* 手机号 */
	private String telephone;
	/* email */
	private String email;
	/* 性别 */
	private int sex;
	/* 生日 */
	private Date birthday;
	/* 创建时间 */
	private Date createTime;
	/* 角色ID */
	private int roleid;
	/* 权限页IDS */
	private String pageIds;
	/* 系统管理员标识 */
	private int adminTab;
	/**
	 * 状态标志 正常为1,删除为0
	 */
	private int accountState;
	/* 管理等级 */
	private String powerLeave;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getCount()
	{
		return count;
	}
	public void setCount(String count)
	{
		this.count = count;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getDeptId()
	{
		return deptId;
	}
	public void setDeptId(int deptId)
	{
		this.deptId = deptId;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getLoginIP()
	{
		return loginIP;
	}
	public void setLoginIP(String loginIP)
	{
		this.loginIP = loginIP;
	}
	public Date getLoginTime()
	{
		return loginTime;
	}
	public void setLoginTime(Date loginTime)
	{
		this.loginTime = loginTime;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public int getSex()
	{
		return sex;
	}
	public void setSex(int sex)
	{
		this.sex = sex;
	}
	public Date getBirthday()
	{
		return birthday;
	}
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}
	public Date getCreateTime()
	{
		return createTime;
	}
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	public int getRoleid()
	{
		return roleid;
	}
	public void setRoleid(int roleid)
	{
		this.roleid = roleid;
	}
	public String getPageIds()
	{
		return pageIds;
	}
	public void setPageIds(String pageIds)
	{
		this.pageIds = pageIds;
	}
	public int getAdminTab()
	{
		return adminTab;
	}
	public void setAdminTab(int adminTab)
	{
		this.adminTab = adminTab;
	}
	public int getAccountState()
	{
		return accountState;
	}
	public void setAccountState(int accountState)
	{
		this.accountState = accountState;
	}
	public String getPowerLeave()
	{
		return powerLeave;
	}
	public void setPowerLeave(String powerLeave)
	{
		this.powerLeave = powerLeave;
	}
	
	
}
