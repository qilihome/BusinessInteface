package com.weichat.boss.service.album.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.CustomerAlbumMapper;
import com.weichat.boss.data.pojo.CustomerAlbum;
import com.weichat.boss.data.pojo.CustomerAlbumExample;
import com.weichat.boss.service.album.CustomerAlbumService;

@Service("customerAlbumService")
@Transactional
public class CustomerAlbumServiceImpl implements CustomerAlbumService
{
	@Autowired
	private CustomerAlbumMapper customerAlbumMapper;

	@Override
	public int countByExample(CustomerAlbumExample example)
	{

		return customerAlbumMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(CustomerAlbumExample example)
	{

		return customerAlbumMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return customerAlbumMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(CustomerAlbum record)
	{

		return customerAlbumMapper.insert(record);
	}

	@Override
	public int insertSelective(CustomerAlbum record)
	{

		return customerAlbumMapper.insertSelective(record);
	}

	@Override
	public List<CustomerAlbum> selectByExample(CustomerAlbumExample example)
	{

		return customerAlbumMapper.selectByExample(example);
	}

	@Override
	public CustomerAlbum selectByPrimaryKey(Integer id)
	{

		return customerAlbumMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(CustomerAlbum record, CustomerAlbumExample example)
	{

		return customerAlbumMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(CustomerAlbum record, CustomerAlbumExample example)
	{

		return customerAlbumMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(CustomerAlbum record)
	{

		return customerAlbumMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(CustomerAlbum record)
	{

		return customerAlbumMapper.updateByPrimaryKeySelective(record);
	}
}
