package com.weichat.boss.service.vote.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.VoteMapper;
import com.weichat.boss.data.pojo.Vote;
import com.weichat.boss.data.pojo.VoteExample;
import com.weichat.boss.service.vote.VoteService;

@Service("voteService")
@Transactional
public class VoteServiceImpl implements VoteService
{
	@Autowired
	private VoteMapper voteMapper;

	@Override
	public int countByExample(VoteExample example)
	{

		return voteMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(VoteExample example)
	{

		return voteMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return voteMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Vote record)
	{

		return voteMapper.insert(record);
	}

	@Override
	public int insertSelective(Vote record)
	{

		return voteMapper.insertSelective(record);
	}

	@Override
	public List<Vote> selectByExample(VoteExample example)
	{

		return voteMapper.selectByExample(example);
	}

	@Override
	public Vote selectByPrimaryKey(Integer id)
	{

		return voteMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(Vote record, VoteExample example)
	{

		return voteMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(Vote record, VoteExample example)
	{

		return voteMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(Vote record)
	{

		return voteMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(Vote record)
	{

		return voteMapper.updateByPrimaryKeySelective(record);
	}

}
