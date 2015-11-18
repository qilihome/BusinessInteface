package com.weichat.boss.service.templatecontent;

import java.util.List;

import com.weichat.boss.data.pojo.CustomerTemplateContent;
import com.weichat.boss.data.pojo.CustomerTemplateContentExample;

public interface CustomerTemplateContentService
{
	int countByExample(CustomerTemplateContentExample example);

	int deleteByExample(CustomerTemplateContentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(CustomerTemplateContent record);

	int insertSelective(CustomerTemplateContent record);

	List<CustomerTemplateContent> selectByExample(CustomerTemplateContentExample example);

	CustomerTemplateContent selectByPrimaryKey(Integer id);

	int updateByExampleSelective(CustomerTemplateContent record, CustomerTemplateContentExample example);

	int updateByExample(CustomerTemplateContent record, CustomerTemplateContentExample example);

	int updateByPrimaryKeySelective(CustomerTemplateContent record);

	int updateByPrimaryKey(CustomerTemplateContent record);
}
