package com.weichat.boss.service.templatearea.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.TemplateAreaMapper;
import com.weichat.boss.data.pojo.TemplateArea;
import com.weichat.boss.data.pojo.TemplateAreaExample;
import com.weichat.boss.service.templatearea.TemplateAreaService;

@Service("templateAreaService")
@Transactional
public class TemplateAreaServiceImpl implements TemplateAreaService
{
	@Autowired
	private TemplateAreaMapper templateAreaMapper;

	@Override
	public int countByExample(TemplateAreaExample example)
	{

		return templateAreaMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(TemplateAreaExample example)
	{

		return templateAreaMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return templateAreaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(TemplateArea record)
	{

		return templateAreaMapper.insert(record);
	}

	@Override
	public int insertSelective(TemplateArea record)
	{

		return templateAreaMapper.insertSelective(record);
	}

	@Override
	public List<TemplateArea> selectByExample(TemplateAreaExample example)
	{

		return templateAreaMapper.selectByExample(example);
	}

	@Override
	public TemplateArea selectByPrimaryKey(Integer id)
	{

		return templateAreaMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(TemplateArea record, TemplateAreaExample example)
	{

		return templateAreaMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(TemplateArea record, TemplateAreaExample example)
	{

		return templateAreaMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(TemplateArea record)
	{

		return templateAreaMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(TemplateArea record)
	{

		return templateAreaMapper.updateByPrimaryKeySelective(record);
	}

}
