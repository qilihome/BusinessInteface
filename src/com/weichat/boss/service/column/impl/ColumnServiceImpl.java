/**
 * 
 */
package com.weichat.boss.service.column.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.ColumnMapper;
import com.weichat.boss.data.pojo.Column;
import com.weichat.boss.data.pojo.ColumnExample;
import com.weichat.boss.service.column.ColumnService;

/**
 * @author yinxianwen
 * 
 */
@Service("columnService")
@Transactional
public class ColumnServiceImpl implements ColumnService
{
	private ColumnMapper columnMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#countByExample(com.weichat.boss.data.pojo.ColumnExample)
	 */
	@Override
	public int countByExample(ColumnExample example)
	{

		return columnMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#deleteByExample(com.weichat.boss.data.pojo.ColumnExample)
	 */
	@Override
	public int deleteByExample(ColumnExample example)
	{

		return columnMapper.deleteByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return columnMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#insert(com.weichat.boss.data.pojo.Column)
	 */
	@Override
	public int insert(Column record)
	{

		return columnMapper.insert(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#insertSelective(com.weichat.boss.data.pojo.Column)
	 */
	@Override
	public int insertSelective(Column record)
	{

		return columnMapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#selectByExample(com.weichat.boss.data.pojo.ColumnExample)
	 */
	@Override
	public List<Column> selectByExample(ColumnExample example)
	{

		return columnMapper.selectByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Column selectByPrimaryKey(Integer id)
	{

		return columnMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#updateByExample(com.weichat.boss.data.pojo.Column,
	 *      com.weichat.boss.data.pojo.ColumnExample)
	 */
	@Override
	public int updateByExample(Column record, ColumnExample example)
	{

		return columnMapper.updateByExample(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#updateByExampleSelective(com.weichat.boss.data.pojo.Column,
	 *      com.weichat.boss.data.pojo.ColumnExample)
	 */
	@Override
	public int updateByExampleSelective(Column record, ColumnExample example)
	{

		return columnMapper.updateByExampleSelective(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#updateByPrimaryKey(com.weichat.boss.data.pojo.Column)
	 */
	@Override
	public int updateByPrimaryKey(Column record)
	{

		return columnMapper.updateByPrimaryKey(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.column.ColumnService#updateByPrimaryKeySelective(com.weichat.boss.data.pojo.Column)
	 */
	@Override
	public int updateByPrimaryKeySelective(Column record)
	{

		return columnMapper.updateByPrimaryKeySelective(record);
	}
}
