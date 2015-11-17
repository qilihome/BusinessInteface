package com.weichat.boss.service.vote;

import java.util.List;

import com.weichat.boss.data.pojo.VoteRecord;
import com.weichat.boss.data.pojo.VoteRecordExample;

public interface VoteRecordService
{
	int countByExample(VoteRecordExample example);

	int deleteByExample(VoteRecordExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(VoteRecord record);

	int insertSelective(VoteRecord record);

	List<VoteRecord> selectByExample(VoteRecordExample example);

	VoteRecord selectByPrimaryKey(Integer id);

	int updateByExampleSelective(VoteRecord record, VoteRecordExample example);

	int updateByExample(VoteRecord record, VoteRecordExample example);

	int updateByPrimaryKeySelective(VoteRecord record);

	int updateByPrimaryKey(VoteRecord record);
}
