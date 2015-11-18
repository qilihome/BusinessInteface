package com.weichat.boss.data.pojo;

public class Column
{
	private Integer id;

	private Integer channelid;

	private Integer moduleid;

	private Integer customerid;

	private String name;

	private Integer showname;

	private String summary;

	private Integer showsummary;

	private String detail;

	private Integer showdetail;

	private Integer type;

	private Integer sequence;

	private String logo;

	private String content;

	private String backup1;

	private String backup2;

	private String backup3;

	private String backup4;

	private String createtime;

	private Integer status;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getChannelid()
	{
		return channelid;
	}

	public void setChannelid(Integer channelid)
	{
		this.channelid = channelid;
	}

	public Integer getModuleid()
	{
		return moduleid;
	}

	public void setModuleid(Integer moduleid)
	{
		this.moduleid = moduleid;
	}

	public Integer getCustomerid()
	{
		return customerid;
	}

	public void setCustomerid(Integer customerid)
	{
		this.customerid = customerid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name == null ? null : name.trim();
	}

	public Integer getShowname()
	{
		return showname;
	}

	public void setShowname(Integer showname)
	{
		this.showname = showname;
	}

	public String getSummary()
	{
		return summary;
	}

	public void setSummary(String summary)
	{
		this.summary = summary == null ? null : summary.trim();
	}

	public Integer getShowsummary()
	{
		return showsummary;
	}

	public void setShowsummary(Integer showsummary)
	{
		this.showsummary = showsummary;
	}

	public String getDetail()
	{
		return detail;
	}

	public void setDetail(String detail)
	{
		this.detail = detail == null ? null : detail.trim();
	}

	public Integer getShowdetail()
	{
		return showdetail;
	}

	public void setShowdetail(Integer showdetail)
	{
		this.showdetail = showdetail;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public Integer getSequence()
	{
		return sequence;
	}

	public void setSequence(Integer sequence)
	{
		this.sequence = sequence;
	}

	public String getLogo()
	{
		return logo;
	}

	public void setLogo(String logo)
	{
		this.logo = logo == null ? null : logo.trim();
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content == null ? null : content.trim();
	}

	public String getBackup1()
	{
		return backup1;
	}

	public void setBackup1(String backup1)
	{
		this.backup1 = backup1 == null ? null : backup1.trim();
	}

	public String getBackup2()
	{
		return backup2;
	}

	public void setBackup2(String backup2)
	{
		this.backup2 = backup2 == null ? null : backup2.trim();
	}

	public String getBackup3()
	{
		return backup3;
	}

	public void setBackup3(String backup3)
	{
		this.backup3 = backup3 == null ? null : backup3.trim();
	}

	public String getBackup4()
	{
		return backup4;
	}

	public void setBackup4(String backup4)
	{
		this.backup4 = backup4 == null ? null : backup4.trim();
	}

	public String getCreatetime()
	{
		return createtime;
	}

	public void setCreatetime(String createtime)
	{
		this.createtime = createtime == null ? null : createtime.trim();
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}
}