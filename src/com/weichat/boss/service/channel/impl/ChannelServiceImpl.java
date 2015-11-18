/**
 * 
 */
package com.weichat.boss.service.channel.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.ChannelMapper;
import com.weichat.boss.data.pojo.Channel;
import com.weichat.boss.data.pojo.ChannelExample;
import com.weichat.boss.service.channel.ChannelService;

/**
 * @author yinxianwen
 * 
 */
@Service("channelService")
@Transactional
public class ChannelServiceImpl implements ChannelService
{
	private ChannelMapper channelMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#countByExample(com.weichat.boss.data.pojo.ChannelExample)
	 */
	@Override
	public int countByExample(ChannelExample example)
	{
		return channelMapper.countByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#deleteByExample(com.weichat.boss.data.pojo.ChannelExample)
	 */
	@Override
	public int deleteByExample(ChannelExample example)
	{

		return channelMapper.deleteByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public int deleteByPrimaryKey(Integer id)
	{
		return channelMapper.deleteByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#insert(com.weichat.boss.data.pojo.Channel)
	 */
	@Override
	public int insert(Channel record)
	{

		return channelMapper.insert(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#insertSelective(com.weichat.boss.data.pojo.Channel)
	 */
	@Override
	public int insertSelective(Channel record)
	{
		return channelMapper.insertSelective(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#selectByExample(com.weichat.boss.data.pojo.ChannelExample)
	 */
	@Override
	public List<Channel> selectByExample(ChannelExample example)
	{
		return channelMapper.selectByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public Channel selectByPrimaryKey(Integer id)
	{
		return channelMapper.selectByPrimaryKey(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#updateByExample(com.weichat.boss.data.pojo.Channel,
	 *      com.weichat.boss.data.pojo.ChannelExample)
	 */
	@Override
	public int updateByExample(Channel record, ChannelExample example)
	{
		return channelMapper.updateByExample(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#updateByExampleSelective(com.weichat.boss.data.pojo.Channel,
	 *      com.weichat.boss.data.pojo.ChannelExample)
	 */
	@Override
	public int updateByExampleSelective(Channel record, ChannelExample example)
	{
		return channelMapper.updateByExampleSelective(record, example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#updateByPrimaryKey(com.weichat.boss.data.pojo.Channel)
	 */
	@Override
	public int updateByPrimaryKey(Channel record)
	{
		return channelMapper.updateByPrimaryKey(record);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weichat.boss.service.channel.ChannelService#updateByPrimaryKeySelective(com.weichat.boss.data.pojo.Channel)
	 */
	@Override
	public int updateByPrimaryKeySelective(Channel record)
	{
		return channelMapper.updateByPrimaryKeySelective(record);
	}
}
