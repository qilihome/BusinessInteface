package com.weichat.boss.data.pojo;

import java.util.Date;

/**
 * 操作员角色表tb_sys_ROLE
 * 
 * @author liqi
 * phone 18771970972
 * qq 197399622
 *
 */
public class Role
{
	/* 角色ID */
	private int id;
	/* 角色名称 */
	private String roleName;
	/* 权限页IDS */
	private String pageID;
	/* 建档人ID */
	private int adduser;
	/* 建档时间 */
	private Date addTime;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}

	public String getPageID()
	{
		return pageID;
	}

	public void setPageID(String pageID)
	{
		this.pageID = pageID;
	}

	public int getAdduser()
	{
		return adduser;
	}

	public void setAdduser(int adduser)
	{
		this.adduser = adduser;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

}
