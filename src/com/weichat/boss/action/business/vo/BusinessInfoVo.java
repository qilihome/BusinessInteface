package com.weichat.boss.action.business.vo;

import com.weichat.boss.data.pojo.BusinessInfo;

public class BusinessInfoVo extends BusinessInfo
{
	private String businessTypeName;
	/*操作人name*/
	private String name;

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}
