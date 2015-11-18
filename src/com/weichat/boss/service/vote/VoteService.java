package com.weichat.boss.service.vote;

import java.util.List;

import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteExample;

public interface VoteService
{
	int countByExample(VoteExample example);

	int deleteByExample(VoteExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Vote record);

	int insertSelective(Vote record);

	List<Vote> selectByExample(VoteExample example);

	Vote selectByPrimaryKey(Integer id);

	int updateByExampleSelective(Vote record, VoteExample example);

	int updateByExample(Vote record, VoteExample example);

	int updateByPrimaryKeySelective(Vote record);

	int updateByPrimaryKey(Vote record);
}
