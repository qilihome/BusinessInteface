package com.weichat.boss.service.vote;

import java.util.List;

import com.weichat.boss.data.pojo.VoteOption;
import com.weichat.boss.data.pojo.VoteOptionExample;

public interface VoteOptionService
{
	int rateVoteOption(Integer id);

	int countByExample(VoteOptionExample example);

	int deleteByExample(VoteOptionExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(VoteOption record);

	int insertSelective(VoteOption record);

	List<VoteOption> selectByExample(VoteOptionExample example);

	VoteOption selectByPrimaryKey(Integer id);

	int updateByExampleSelective(VoteOption record, VoteOptionExample example);

	int updateByExample(VoteOption record, VoteOptionExample example);

	int updateByPrimaryKeySelective(VoteOption record);

	int updateByPrimaryKey(VoteOption record);
}
