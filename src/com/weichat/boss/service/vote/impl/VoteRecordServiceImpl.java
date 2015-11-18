package com.weichat.boss.service.vote.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weichat.boss.data.dao.VoteRecordMapper;
import com.weichat.boss.data.pojo.VoteRecord;
import com.weichat.boss.data.pojo.VoteRecordExample;
import com.weichat.boss.service.vote.VoteRecordService;

@Service("voteRecordService")
@Transactional
public class VoteRecordServiceImpl implements VoteRecordService
{
	@Autowired
	private VoteRecordMapper voteRecordMapper;

	@Override
	public int countByExample(VoteRecordExample example)
	{

		return voteRecordMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(VoteRecordExample example)
	{

		return voteRecordMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id)
	{

		return voteRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(VoteRecord record)
	{

		return voteRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(VoteRecord record)
	{

		return voteRecordMapper.insertSelective(record);
	}

	@Override
	public List<VoteRecord> selectByExample(VoteRecordExample example)
	{

		return voteRecordMapper.selectByExample(example);
	}

	@Override
	public VoteRecord selectByPrimaryKey(Integer id)
	{

		return voteRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExample(VoteRecord record, VoteRecordExample example)
	{

		return voteRecordMapper.updateByExample(record, example);
	}

	@Override
	public int updateByExampleSelective(VoteRecord record, VoteRecordExample example)
	{

		return voteRecordMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByPrimaryKey(VoteRecord record)
	{

		return voteRecordMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(VoteRecord record)
	{

		return voteRecordMapper.updateByPrimaryKeySelective(record);
	}

}
