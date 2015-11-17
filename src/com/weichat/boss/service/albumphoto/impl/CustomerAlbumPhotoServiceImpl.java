/**
 * 
 */
package com.weichat.boss.service.albumphoto.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.CustomerAlbumPhotoMapper;
import com.weichat.boss.data.pojo.CustomerAlbumPhoto;
import com.weichat.boss.data.pojo.CustomerAlbumPhotoExample;
import com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService;

/**
 * 相集内的图片管理
 * 
 * @author yinxianwen
 * 
 */
@Service("customerAlbumPhotoService")
@Transactional
public class CustomerAlbumPhotoServiceImpl implements CustomerAlbumPhotoService
{
	@Autowired
	private CustomerAlbumPhotoMapper customerAlbumPhotoMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#countByExample(com.weichat.boss.data.pojo.CustomerAlbumPhotoExample)
	 */
	@Override
	public int countByExample(CustomerAlbumPhotoExample example)
	{

		return customerAlbumPhotoMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#deleteByExample(com.weichat.boss.data.pojo.CustomerAlbumPhotoExample)
	 */
	@Override
	public int deleteByExample(CustomerAlbumPhotoExample example)
	{

		return customerAlbumPhotoMapper.deleteByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return customerAlbumPhotoMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#insert(com.weichat.boss.data.pojo.CustomerAlbumPhoto)
	 */
	@Override
	public int insert(CustomerAlbumPhoto record)
	{

		return customerAlbumPhotoMapper.insert(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#insertSelective(com.weichat.boss.data.pojo.CustomerAlbumPhoto)
	 */
	@Override
	public int insertSelective(CustomerAlbumPhoto record)
	{

		return customerAlbumPhotoMapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#selectByExample(com.weichat.boss.data.pojo.CustomerAlbumPhotoExample)
	 */
	@Override
	public List<CustomerAlbumPhoto> selectByExample(CustomerAlbumPhotoExample example)
	{

		return customerAlbumPhotoMapper.selectByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public CustomerAlbumPhoto selectByPrimaryKey(Integer id)
	{

		return customerAlbumPhotoMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#updateByExample(com.weichat.boss.data.pojo.CustomerAlbumPhoto,
	 *      com.weichat.boss.data.pojo.CustomerAlbumPhotoExample)
	 */
	@Override
	public int updateByExample(CustomerAlbumPhoto record, CustomerAlbumPhotoExample example)
	{

		return customerAlbumPhotoMapper.updateByExample(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#updateByExampleSelective(com.weichat.boss.data.pojo.CustomerAlbumPhoto,
	 *      com.weichat.boss.data.pojo.CustomerAlbumPhotoExample)
	 */
	@Override
	public int updateByExampleSelective(CustomerAlbumPhoto record, CustomerAlbumPhotoExample example)
	{

		return customerAlbumPhotoMapper.updateByExampleSelective(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#updateByPrimaryKey(com.weichat.boss.data.pojo.CustomerAlbumPhoto)
	 */
	@Override
	public int updateByPrimaryKey(CustomerAlbumPhoto record)
	{

		return customerAlbumPhotoMapper.updateByPrimaryKey(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.albumphoto.CustomerAlbumPhotoService#updateByPrimaryKeySelective(com.weichat.boss.data.pojo.CustomerAlbumPhoto)
	 */
	@Override
	public int updateByPrimaryKeySelective(CustomerAlbumPhoto record)
	{

		return customerAlbumPhotoMapper.updateByPrimaryKeySelective(record);
	}
}
