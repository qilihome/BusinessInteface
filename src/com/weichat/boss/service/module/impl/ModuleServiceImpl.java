/**
 * 
 */
package com.weichat.boss.service.module.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.ModuleMapper;
import com.weichat.boss.data.pojo.Module;
import com.weichat.boss.data.pojo.ModuleExample;
import com.weichat.boss.service.module.ModuleService;

/**
 * @author yinxianwen
 * 
 */
@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService
{
	private ModuleMapper moduleMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#countByExample(com.weichat.boss.data.pojo.ModuleExample)
	 */
	@Override
	public int countByExample(ModuleExample example)
	{

		return moduleMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#deleteByExample(com.weichat.boss.data.pojo.ModuleExample)
	 */
	@Override
	public int deleteByExample(ModuleExample example)
	{

		return moduleMapper.deleteByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return moduleMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#insert(com.weichat.boss.data.pojo.Module)
	 */
	@Override
	public int insert(Module record)
	{

		return moduleMapper.insert(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#insertSelective(com.weichat.boss.data.pojo.Module)
	 */
	@Override
	public int insertSelective(Module record)
	{

		return moduleMapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#selectByExample(com.weichat.boss.data.pojo.ModuleExample)
	 */
	@Override
	public List<Module> selectByExample(ModuleExample example)
	{

		return moduleMapper.selectByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Module selectByPrimaryKey(Integer id)
	{

		return moduleMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#updateByExample(com.weichat.boss.data.pojo.Module,
	 *      com.weichat.boss.data.pojo.ModuleExample)
	 */
	@Override
	public int updateByExample(Module record, ModuleExample example)
	{

		return moduleMapper.updateByExample(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#updateByExampleSelective(com.weichat.boss.data.pojo.Module,
	 *      com.weichat.boss.data.pojo.ModuleExample)
	 */
	@Override
	public int updateByExampleSelective(Module record, ModuleExample example)
	{

		return moduleMapper.updateByExampleSelective(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#updateByPrimaryKey(com.weichat.boss.data.pojo.Module)
	 */
	@Override
	public int updateByPrimaryKey(Module record)
	{

		return moduleMapper.updateByPrimaryKey(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.module.ModuleService#updateByPrimaryKeySelective(com.weichat.boss.data.pojo.Module)
	 */
	@Override
	public int updateByPrimaryKeySelective(Module record)
	{

		return moduleMapper.updateByPrimaryKeySelective(record);
	}
}
