package com.weichat.boss.service.template.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.TemplateMapper;
import com.weichat.boss.data.pojo.Template;
import com.weichat.boss.data.pojo.TemplateExample;
import com.weichat.boss.service.template.TemplateService;

@Service("templateService")
@Transactional
public class TemplateServiceImpl implements TemplateService
{
	@Autowired
	private TemplateMapper templateMapper;

	@Override
	public int countByExample(TemplateExample example)
	{
		return templateMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TemplateExample example)
	{

		return templateMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return templateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Template record)
	{

		return templateMapper.insert(record);
	}

	@Override
	public int insertSelective(Template record)
	{

		return templateMapper.insertSelective(record);
	}

	@Override
	public List<Template> selectByExample(TemplateExample example)
	{

		return templateMapper.selectByExample(example);
	}

	@Override
	public Template selectByPrimaryKey(Integer id)
	{

		return templateMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(Template record, TemplateExample example)
	{

		return templateMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(Template record, TemplateExample example)
	{

		return templateMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(Template record)
	{

		return templateMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Template record)
	{

		return templateMapper.updateByPrimaryKeySelective(record);
	}

}
