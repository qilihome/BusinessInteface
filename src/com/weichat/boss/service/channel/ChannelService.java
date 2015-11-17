package com.weichat.boss.service.channel;

import java.util.List;

import com.weichat.boss.data.pojo.Channel;
import com.weichat.boss.data.pojo.ChannelExample;

public interface ChannelService
{
	int countByExample(ChannelExample example);

	int deleteByExample(ChannelExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Channel record);

	int insertSelective(Channel record);

	List<Channel> selectByExample(ChannelExample example);

	Channel selectByPrimaryKey(Integer id);

	int updateByExampleSelective(Channel record, ChannelExample example);

	int updateByExample(Channel record, ChannelExample example);

	int updateByPrimaryKeySelective(Channel record);

	int updateByPrimaryKey(Channel record);
}
