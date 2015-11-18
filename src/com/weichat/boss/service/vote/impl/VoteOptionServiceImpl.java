package com.weichat.boss.service.vote.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.VoteOptionMapper;
import com.weichat.boss.data.pojo.VoteOption;
import com.weichat.boss.data.pojo.VoteOptionExample;
import com.weichat.boss.service.vote.VoteOptionService;

@Service("voteOptionService")
@Transactional
public class VoteOptionServiceImpl implements VoteOptionService
{
	@Autowired
	private VoteOptionMapper voteOptionMapper;

	
	@Override
	public int rateVoteOption(Integer id)
	{
		return voteOptionMapper.rateVoteOption(id);
	}

	@Override
	public int countByExample(VoteOptionExample example)
	{

		return voteOptionMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(VoteOptionExample example)
	{

		return voteOptionMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return voteOptionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VoteOption record)
	{

		return voteOptionMapper.insert(record);
	}

	@Override
	public int insertSelective(VoteOption record)
	{

		return voteOptionMapper.insertSelective(record);
	}

	@Override
	public List<VoteOption> selectByExample(VoteOptionExample example)
	{

		return voteOptionMapper.selectByExample(example);
	}

	@Override
	public VoteOption selectByPrimaryKey(Integer id)
	{

		return voteOptionMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(VoteOption record, VoteOptionExample example)
	{

		return voteOptionMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(VoteOption record, VoteOptionExample example)
	{

		return voteOptionMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(VoteOption record)
	{

		return voteOptionMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(VoteOption record)
	{

		return voteOptionMapper.updateByPrimaryKeySelective(record);
	}

}
