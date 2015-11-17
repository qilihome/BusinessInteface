/**
 * 
 */
package com.weichat.boss.service.templatecontent.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.CustomerTemplateContentMapper;
import com.weichat.boss.data.pojo.CustomerTemplateContent;
import com.weichat.boss.data.pojo.CustomerTemplateContentExample;
import com.weichat.boss.service.templatecontent.CustomerTemplateContentService;

@Service("customerTemplateContentService")
@Transactional
public class CustomerTemplateContentServiceImpl implements CustomerTemplateContentService
{
	@Autowired
	private CustomerTemplateContentMapper customerTemplateContentMapper;

	@Override
	public int countByExample(CustomerTemplateContentExample example)
	{

		return customerTemplateContentMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CustomerTemplateContentExample example)
	{

		return customerTemplateContentMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return customerTemplateContentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CustomerTemplateContent record)
	{

		return customerTemplateContentMapper.insert(record);
	}

	@Override
	public int insertSelective(CustomerTemplateContent record)
	{

		return customerTemplateContentMapper.insertSelective(record);
	}

	@Override
	public List<CustomerTemplateContent> selectByExample(CustomerTemplateContentExample example)
	{

		return customerTemplateContentMapper.selectByExample(example);
	}

	@Override
	public CustomerTemplateContent selectByPrimaryKey(Integer id)
	{

		return customerTemplateContentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(CustomerTemplateContent record, CustomerTemplateContentExample example)
	{

		return customerTemplateContentMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(CustomerTemplateContent record, CustomerTemplateContentExample example)
	{

		return customerTemplateContentMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(CustomerTemplateContent record)
	{

		return customerTemplateContentMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(CustomerTemplateContent record)
	{

		return customerTemplateContentMapper.updateByPrimaryKeySelective(record);
	}

}
